package booklibrary.services;

import booklibrary.models.Post;
import booklibrary.models.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
    boolean checkpw(String username, String password_hash);
    //User login(String username, String password);
    User register(String username, String password, String fullname, String email);
    void setPassword(String username, String newPassword);
    public User findUserByUsername(String username);
}
