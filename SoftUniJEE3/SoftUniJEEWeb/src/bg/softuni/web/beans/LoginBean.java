package bg.softuni.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.entity.UserModel;
import bg.softuni.service.UserServiceLocal;
import bg.softuni.web.utils.GeneralUtils;
import bg.softuni.web.utils.MessageUtils;

/**
 * The purpose of this class is to provide backend functionality of the login
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private HttpServletRequest request;

	@EJB
	UserServiceLocal userService;

	private String username;
	private String password;

	private static final String SUCCESS_LOGIN_REDIRECT = "/page/index?faces-redirect=true";
	private static final String LOGIN_PAGE_REDIRECT = "/pageAccess/index?faces-redirect=true";

	@PostConstruct
	public void init() {
		// TODO
	}

	/**
	 * Implement application login logic
	 * 
	 * @return
	 */
	public String login() {
		
		String encryptedPass = GeneralUtils.encodeSha256Password(password);

		UserModel user = userService.loginUser(username, encryptedPass);

		if (null == user) {
			MessageUtils.addErrorMessage("login.error.invalid.credentials");

			return "";
		} else {
			request.getSession().setAttribute("LOGGED_USER", user);
			return SUCCESS_LOGIN_REDIRECT;
		}
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
