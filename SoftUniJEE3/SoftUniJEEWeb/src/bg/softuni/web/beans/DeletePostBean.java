package bg.softuni.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import bg.softuni.entity.PostModel;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "deletePostBean")
@RequestScoped
public class DeletePostBean {

	@Inject
	HttpServletRequest request;
	
	@EJB
	PostServiceLocal postService;
	
	private PostModel post;

	public PostModel getPost() {
		return post;
	}

	public void setPost(PostModel post) {
		this.post = post;
	}

	@PostConstruct
	public void init() {
		String id = request.getParameter("id");
		
		if(StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)){
			postService.delete(Long.valueOf(id));
		}
	}
	
	public String delete(){
		return "posts";
	}
}