package bg.softuni.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bg.softuni.entity.PostModel;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "homeBean")
@ViewScoped
public class HomeBean {

	@EJB
	PostServiceLocal postService;

	@PostConstruct
	public void init() {
	}

	public List<PostModel> getAllPosts() {
		return postService.findAllPosts();
	}

	public List<PostModel> get3Posts() {

		List<PostModel> posts = postService.findAllPosts();
		List<PostModel> first3Posts = new ArrayList<PostModel>();

		for (int i = 0; i < 3; i++) {
			first3Posts.add(posts.get(i));
		}
		return first3Posts;
	}

	public List<PostModel> getAsidePosts() {

		List<PostModel> posts = postService.findAllPosts();
		List<PostModel> postsTitle = new ArrayList<PostModel>();

		for (int i = 0; i < 5; i++) {
			postsTitle.add(posts.get(i));
		}
		return postsTitle;
	}

	public String viewPost() {
		return "postView";
	}
}
