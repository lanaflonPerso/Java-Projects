package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.entity.PostModel;
import bg.softuni.entity.UserModel;

@Local
public interface PostServiceLocal {
	
	List<PostModel> findAllPosts();
	PostModel getPostById(int id);
	public PostModel save(PostModel entity);
}
