package booklibrary.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(length = 60)
    private String password_hash;

    @Column(length = 100)
    private String fullname;


    @Column(nullable = false,length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String picturelink;

    @Column(nullable = false)
    private Date date = new Date();

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<Book>();

    @OneToMany(mappedBy = "user")
    private Set<Comment_book> cmntbooks = new HashSet<Comment_book>();

    @OneToMany(mappedBy = "user")
    private Set<Event> events = new HashSet<Event>();

    @OneToMany(mappedBy = "user")
    private Set<Comment_event> cmntevents = new HashSet<Comment_event>();

    @OneToMany(mappedBy = "user")
    private Set<Comment_post> cmntposts = new HashSet<Comment_post>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String  password_hash) {
        this.password_hash = password_hash;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Comment_book> getCmntbooks() {
        return cmntbooks;
    }

    public void setCmntbooks(Set<Comment_book> cmntbooks) {
        this.cmntbooks = cmntbooks;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Comment_event> getCmntevents() {
        return cmntevents;
    }

    public void setCmntevents(Set<Comment_event> cmntevents) {
        this.cmntevents = cmntevents;
    }

    public Set<Comment_post> getCmntposts() {
        return cmntposts;
    }

    public void setCmntposts(Set<Comment_post> cmntposts) {
        this.cmntposts = cmntposts;
    }

    public User() {
    }

    public User(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    public User(Long id, String username, String fullname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", picturelink='" + picturelink + '\'' +
                ", date=" + date +
                ", posts=" + posts +
                ", roles=" + roles +
                ", books=" + books +
                ", cmntbooks=" + cmntbooks +
                ", events=" + events +
                ", cmntevents=" + cmntevents +
                ", cmntposts=" + cmntposts +
                '}';
    }
}
