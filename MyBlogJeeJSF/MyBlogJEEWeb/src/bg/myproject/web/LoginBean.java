package bg.myproject.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * The purpose of this class is to provide backend functionality of the login
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//beans.xml need to be added in WEB-INF in order CDI to work
	@Inject
	private HttpServletRequest request;
	
	private String username;
	private String password;
	

	private static final String SUCCESS_LOGIN_REDIRECT = "/page/index?faces-redirect=true";
	private static final String LOGIN_PAGE_REDIRECT = "/page/login?faces-redirect=true";
	
	@PostConstruct
	public void init() {
		//TODO
	}
	
	/**
	 * Implement application login logic 
	 * 
	 * @return
	 */
	public String login() {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid credentials"));

			return "";
		} else if("admin".equals(username) && "123".equals(password)){
			// If we want to avoid using CDI for accessing the request we can take it from FacesCondex by using:
			// HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.getSession().setAttribute("LOGGED_USER", username);
			return SUCCESS_LOGIN_REDIRECT;	
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid credentials"));
		return "";
	}

	/**
	 * Implement application logout logic
	 * 
	 * @return
	 */
	public String logout() {
		request.getSession().invalidate();
		return LOGIN_PAGE_REDIRECT;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
