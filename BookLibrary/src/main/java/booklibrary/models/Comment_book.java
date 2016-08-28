package booklibrary.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_books")
public class Comment_book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmntBook;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Book book;

    @Column( length = 100)
    private String TitleComment;

    @Column( length = 500)
    private String textComment;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private Date datePost = new Date();

    public Long getIdCmntBook() { return idCmntBook; }
    public void setIdCmntBook(Long idCmntBook) {
        this.idCmntBook = idCmntBook;
    }

    public Book getBook() { return book;  }
    public void setBook(Book book) {this.book = book;}

    public String getTitleComment() { return TitleComment;  }
    public void setTitleComment(String titleComment) { TitleComment = titleComment;}

    public String getTextComment() {  return textComment;  }
    public void setTextComment(String textComment) {    this.textComment = textComment;}

    public User getUser() { return user; }
    public void setUser(User iduser) {  this.user = user;}

    public Date getDatePost() {  return datePost; }
    public void setDatePost(Date datePost) {    this.datePost = datePost;}

    public Comment_book() {
    }

    public Comment_book(Book book, String TitleComment, String textComment) {
        this.book= book;
        this.TitleComment= TitleComment;
        this.textComment = textComment;
    }

    public Comment_book(Long idCmntBook, Book book, String TitleComment, String textComment, User user) {
        this.idCmntBook = idCmntBook;
        this.book= book;
        this.TitleComment = TitleComment;
        this.textComment = textComment;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment_book{" +
                "idCmntBook=" +idCmntBook +
                ", Book='" +book + '\'' +
                ", TitleComment='" +TitleComment + '\'' +
                ", textComment='" + textComment + '\'' +
                ", author='" + user + '\'' +
                '}';
    }

}
