package modal.bean;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns= {"*.xhtml"})
public class LoginFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if (session != null && session.getAttribute("name") != null) {
			if (!req.getRequestURI().endsWith("/login.xhtml")) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
			}
		} else {
			if (req.getRequestURI().matches(".*(js|css|jpg|png|jepg)")) {
				chain.doFilter(request, response);
			} else {
				req.getRequestDispatcher("login.xhtml").forward(req, res);
			}
		}
	}

}
