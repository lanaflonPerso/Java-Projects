package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

import bg.softuni.entity.PostModel;

@Local
public interface PostServiceLocal {
	
	List<PostModel> findAllPosts();
	PostModel getPostById(Long id);
	public PostModel save(PostModel entity);
	void delete(Long id);
	public PostModel update(PostModel entity);
}
