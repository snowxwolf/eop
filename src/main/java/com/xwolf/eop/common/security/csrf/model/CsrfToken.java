package com.xwolf.eop.common.security.csrf.model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xwolf.eop.common.security.csrf.exception.CsrfException;
import com.xwolf.eop.common.security.csrf.exception.EncryptionException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.StandardPasswordEncoder;



/**
 * 
 * Javabean that holds the generated CSRF data for a session.
 * 
 * @author Rafael Pinto
 *
 */
public class CsrfToken implements Serializable {

	private static final long serialVersionUID = 8399938942623839693L;
	public static final String CSRF_TOKEN_SESSION_ATTRIBUTE = "CsrfToken";

	private String identifier;
	private String value;
	private StandardPasswordEncoder encoder;

	/**
	 * Constructor. <br/>
	 * Generates dynamic the CSRF identifier, token value and encryption keys
	 * per session.
	 * 
	 */
	private CsrfToken() {
		try {
			BytesKeyGenerator keyGenerator = KeyGenerators.secureRandom(16);

			this.identifier = Hex.encodeHexString(keyGenerator.generateKey());
			this.value = Hex.encodeHexString(keyGenerator.generateKey());
			this.encoder = new StandardPasswordEncoder(Hex.encodeHexString(keyGenerator.generateKey()));

		} catch (Exception e) {
			throw new EncryptionException("Error initializing CSRF session parameters", e);
		}
	}

	/**
	 * Creates a new {@link CsrfToken} and attaches it to the informed session.
	 * 
	 * @return the created holder.
	 * @throws CsrfException
	 *             If there is already a CSRF instance in the session.
	 */
	public static final CsrfToken createAndAttach(HttpSession session) throws CsrfException {

		if (get(session) != null) {
			throw new CsrfException("A CSRF token already exists in the session!");
		}

		CsrfToken token = new CsrfToken();
		session.setAttribute(CSRF_TOKEN_SESSION_ATTRIBUTE, token);
		return token;
	}

	/**
	 * @return the holder for this session.
	 */
	public static final CsrfToken get(HttpSession session) {
		return (CsrfToken) session.getAttribute(CSRF_TOKEN_SESSION_ATTRIBUTE);
	}

	/**
	 * Asserts if the informed token value matches the one in the session.
	 * 
	 * @throws CsrfException
	 *             If the validation fails
	 */
	public static void assertToken(HttpServletRequest request) throws CsrfException {
		CsrfToken token = get(request.getSession());

		String encodedToken = request.getHeader(token.getIdentifier());

		if (StringUtils.isBlank(encodedToken)) {
			throw new CsrfException("CSRF token not informed!");
		}

		try {
			if (!token.encoder.matches(token.value, encodedToken)) {
				throw new CsrfException("The informed CSRF token does not match the session one!");
			}
		} catch (IllegalArgumentException e) {
			throw new CsrfException("Invalid CSRF token!", e);
		}
	}

	/**
	 * @return the encrypted token identifier.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @return the encrypted token value. The hash changes per invocation.
	 */
	public String getValue() {
		return this.encoder.encode(this.value);
	}
}
