package com.xwolf.eop.common.security.csrf.config;

import com.xwolf.eop.common.security.csrf.exception.CsrfException;
import com.xwolf.eop.common.security.csrf.model.CsrfToken;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * Listener that attaches a {@link CsrfToken} to the session as soon as it's
 * created.
 * 
 * @author Rafael Pinto
 *
 */
public class CsrfTokenSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		try {
			CsrfToken.createAndAttach(event.getSession());
		} catch(CsrfException e) {
			throw new RuntimeException("Error creating CSRF token for the user", e);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {

	}

}
