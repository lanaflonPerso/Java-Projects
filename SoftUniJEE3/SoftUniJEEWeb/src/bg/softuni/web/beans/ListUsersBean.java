package bg.softuni.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bg.softuni.entity.UserModel;
import bg.softuni.service.UserServiceLocal;

@ManagedBean(name = "listUsersBean")
@ViewScoped
public class ListUsersBean {
	@EJB
	UserServiceLocal userService;

	@PostConstruct
	public void init() {
	}

	public String editAction() {
		return "/page/editUser";
	}

	public String createAction() {
		return "/page/createUser";
	}

	public List<UserModel> getAllUsers() {
		return userService.getAllUsersforDisplay();
	}

}
