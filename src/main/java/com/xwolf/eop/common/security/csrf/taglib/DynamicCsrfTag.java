package com.xwolf.eop.common.security.csrf.taglib;

import com.xwolf.eop.common.security.csrf.model.CsrfToken;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 
 * Taglib that adds a hidden field with the CSRF token and a global JS variable
 * with it's ID.
 * 
 * @author Rafael Pinto
 *
 */
public class DynamicCsrfTag extends TagSupport {

	private static final long serialVersionUID = -7469801744729094510L;
	private static final String JAVASCRIPT_HTML = "<script type='text/javascript'> var $csrfIdentifier = '#identifier#'; </script>";
	private static final String HIDDEN_FIELD_HTML = "<input type='hidden' id='#identifier#' value='#value#'/>";
	private static final String JAVASCRIPT_OPTION = "javascript";
	private static final String HIDDEN_FIELD_OPTION = "hidden_field";

	private String element;

	@Override
	public int doStartTag() throws JspException {
		HttpSession session = this.pageContext.getSession();
		CsrfToken token = CsrfToken.get(session);

		if (token != null) {
			String html = null;

			if (JAVASCRIPT_OPTION.equals(element)) {
				html = JAVASCRIPT_HTML;
			} else if (HIDDEN_FIELD_OPTION.equals(element)) {
				html = HIDDEN_FIELD_HTML;
			} else {
				throw new IllegalArgumentException("Invalid element: " + this.element);
			}

			html = html.replaceAll("#identifier#", token.getIdentifier());
			html = html.replaceAll("#value#", token.getValue());

			try {
				pageContext.getOut().print(html);
			} catch (Exception e) {
				throw new RuntimeException("Error writing CSRF token", e);
			}
		}
		return SKIP_BODY;
	}

	public void setElement(String element) {
		this.element = element;
	}

}
