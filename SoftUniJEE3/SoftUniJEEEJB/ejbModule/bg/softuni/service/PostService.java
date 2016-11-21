package bg.softuni.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bg.softuni.entity.PostModel;

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
    public PostModel getPostById(Long id){
        PostModel post = entityManager.find(PostModel.class, id);
        return post;
    }
	
	@Override
    public PostModel save(PostModel entity) {
        entityManager.persist(entity);
        return entity;
    }
	
	@Override
	public void delete(Long id){
		PostModel post = entityManager.find(PostModel.class, id);
		entityManager.remove(post);
	}
	
    @Override
    public PostModel update(PostModel entity) {
        entityManager.merge(entity);
        entityManager.flush();
        return entity;
    }

}
