package bg.softuni.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import bg.softuni.entity.PostModel;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "postsBean")
@RequestScoped
public class PostsBean {

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
			post = postService.getPostById(Long.valueOf(id));
		}

	}

	public List<PostModel> getAllPosts() {
		
		List<PostModel> posts = postService.findAllPosts();

		for(PostModel post : posts){
			if(post.getContent().length() > 150){
				String cutContent = post.getContent().substring(0, 150);
				post.setContent(cutContent + "...");
			}
		}
		
		return posts;
	}
	
	public String delPost() {
		postService.delete(this.post.getId());
		return "posts";
	}

	public String confirmDeletePost() {
		return "confirmDelete";
	}
	
	public String detailsPost(){
		return "postDetails";
	}

}
