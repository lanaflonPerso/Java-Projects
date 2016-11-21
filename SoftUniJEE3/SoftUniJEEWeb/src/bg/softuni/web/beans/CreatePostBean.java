package bg.softuni.web.beans;

import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import bg.softuni.entity.PostModel;
import bg.softuni.entity.UserModel;
import bg.softuni.service.PostServiceLocal;
import bg.softuni.web.utils.MessageUtils;

@ManagedBean(name = "createPostBean")
@ViewScoped
public class CreatePostBean {

	@Inject
	HttpServletRequest request;

	@EJB
	PostServiceLocal postService;
	
	private PostModel post;
	
	private static final String CREATEPOST_PAGE_REDIRECT = "/page/posts?faces-redirect=true";
	
	@PostConstruct
	public void init() {
		post = new PostModel();
	}
	
	public String createPost() {

		if (!validate()) {
			return null;
		}
		
		Date date = new Date();
		UserModel user = (UserModel) request.getSession().getAttribute("LOGGED_USER");
		post.setDate(date);
		post.setAuthor(user);

		postService.save(post);

		return CREATEPOST_PAGE_REDIRECT;
	}

	public PostModel getPost() {
		return post;
	}

	public void setPost(PostModel post) {
		this.post = post;
	}
	
	protected boolean validate() {
		boolean hasErrors = false;
		if (StringUtils.isBlank(post.getTitle())) {
			MessageUtils.addErrorMessage("error.required.title");
			hasErrors = true;
		}

		if (StringUtils.isBlank(post.getContent())) {
			MessageUtils.addErrorMessage("error.required.content");
			hasErrors = true;
		}

		if (hasErrors) {
			return false;
		}

		return true;
	}

	public boolean hasErrors() {
		Iterator<FacesMessage> messages = FacesContext.getCurrentInstance().getMessages();
		for (; messages.hasNext();) {
			FacesMessage message = messages.next();
			if (message.getSeverity().compareTo(FacesMessage.SEVERITY_ERROR) == 0) {
				return true;
			}
		}

		return false;
	}

}
