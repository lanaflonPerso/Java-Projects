package booklibrary.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 100)
    private String type;

    @Lob
    @Column()
    private String about;

    @OneToMany(mappedBy = "category")
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<Book>();

    @OneToMany(mappedBy = "category")
    private Set<Event> events = new HashSet<Event>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Event> getEvents() {
    return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Category() {
    }

    public Category(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Category(Long id, String name, String about) {
        this.id = id;
        this.name = name;
        this.about = about;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", about='" + about + '\'' +
                ", posts=" + posts +
                ", books=" + books +
                ", events=" + events +
                '}';
    }
}
