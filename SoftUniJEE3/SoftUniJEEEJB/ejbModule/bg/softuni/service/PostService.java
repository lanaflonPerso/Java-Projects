package bg.softuni.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bg.softuni.entity.PostModel;
import bg.softuni.entity.UserModel;

@Stateless
public class PostService implements PostServiceLocal{
	
	@PersistenceContext
    protected EntityManager entityManager;
    
	@SuppressWarnings("unchecked")
	@Override
    public List<PostModel> findAllPosts() {
        String query = "select model from PostModel model order by upper(model.date) desc";
        Query q = entityManager.createQuery(query);

        return q.getResultList();
    }
	
	@Override
    public PostModel getPostById(int id) {
        PostModel post = entityManager.find(PostModel.class, id);
        return post;
    }
	
	@Override
    public PostModel save(PostModel entity) {
        entityManager.persist(entity);
        return entity;
    }
}
