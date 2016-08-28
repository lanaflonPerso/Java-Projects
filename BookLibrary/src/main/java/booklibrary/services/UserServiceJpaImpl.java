package booklibrary.services;

import booklibrary.models.Post;
import booklibrary.models.User;
import booklibrary.repositories.PostRepository;
import booklibrary.repositories.UserRepository;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        String hashed = BCrypt.hashpw(user.getPassword_hash(), BCrypt.gensalt());
        user.setPassword_hash(hashed);
        return this.userRepo.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }

    @Override
    public boolean checkpw(String username, String password_hash) {
        // Provide a sample password check: username == password
        String hashed = BCrypt.hashpw(password_hash, BCrypt.gensalt(12));
        if (BCrypt.checkpw(password_hash, hashed)) {
            return true;
        }
        return false;
    }

    //@Override
    //public User login(String username, String password_hash) {
    //    throw new UnsupportedOperationException("Operation not implemented");
    //}

    @Override
    public User register(String username, String password_hash, String fullname, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword_hash(password_hash);
        user.setFullname(fullname);
        user.setDate(new Date());
        user.setEmail(email);
        user.setRole("User");
        return user;
    }

    @Override
    public void setPassword(String username, String newPassword) {
        throw new UnsupportedOperationException("Operation not implemented");
    }
}
