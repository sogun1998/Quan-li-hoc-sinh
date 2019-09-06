package quanLi.security;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import quanLi.model.Auth;
import quanLi.model.UserRole;
import quanLi.model.Users;
import quanLi.util.Constant;

public class FilterSystem implements HandlerInterceptor {
	Logger logger = Logger.getLogger(FilterSystem.class);
	@Override
	// Khi mot URL se di qua trc khi --> controller
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
		logger.info("Request URI ="+request.getRequestURI());
		Users users = (Users) request.getSession().getAttribute(Constant.USER_INFO);
		if(users == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		if(users!=null) {
			String url = request.getServletPath();
			if(!hasPermission(url, users)) {
				response.sendRedirect(request.getContextPath()+"/access-denied");
				return false;
			}
		}
		return true;
		
		
	}
	private boolean hasPermission(String url, Users users) {
		if(url.contains("/index") || url.contains("/access-denied") || url.contains("/logout")) {
			return true;
		}
		UserRole userRole =(UserRole) users.getUserRoles().iterator().next();
		Set<Auth> auths = userRole.getRole().getAuths();
		for(Object obj : auths) {
			Auth auth = (Auth) obj;
			if(url.contains(auth.getMenu().getUrl())) {
				return auth.getPermision() ==1 ;
			}
		}
		return false;
	}
	
}
