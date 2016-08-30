package booklibrary.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_posts")
public class Comment_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmntPost;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Post post;

    @Column( length = 500)
    private String textComment;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private Date dateComment = new Date();

    public Long getIdCmntPost() { return idCmntPost; }
    public void setIdCmntPost(Long idCmntPost) {
        this.idCmntPost = idCmntPost;
    }

    public Post getPost() { return post;  }
    public void setIdpost(Post post) {this.post = post;}

    public User getUser() { return user; }
    public void setUser(User user) {  this.user = user;}

    public Date getDateComment() {  return dateComment; }
    public void setDateComment(Date dateComment) {    this.dateComment = dateComment;}

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Comment_post() {
    }

    public Comment_post(Post post,String TitleComment, String textComment) {
        this.post= post;
        this.textComment = textComment;
    }

    public Comment_post(Long idCmntPost, Post post,String TitleComment, String textComment) {
        this.idCmntPost = idCmntPost;
        this.post= post;
        this.textComment = textComment;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCmntPost=" +idCmntPost +
                "postid=" +post +
                ", textComment='" + textComment + '\'' +
                '}';
    }


}
