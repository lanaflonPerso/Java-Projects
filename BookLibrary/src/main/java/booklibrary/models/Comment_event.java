package booklibrary.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_events")
public class Comment_event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmntEvent;

    @Column( length = 100)
    private String TitleComment;

    @Column( length = 500)
    private String textComment;

    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
    //private Event event;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private Date dateComment = new Date();

    public Long getIdCmntEvent() { return idCmntEvent; }
    public void setIdCmntEvent(Long idCmntEvent) {
        this.idCmntEvent = idCmntEvent;
    }
    //public Event getEvent() { return event;  }
    //public void setEvent(Event event) {this.event = event;
    //}
    public String getTitleComment() { return TitleComment;  }
    public void setTitleComment(String titleComment) { TitleComment = titleComment;
    }

    public String getTextComment() {  return textComment;  }
    public void setTextComment(String textComment) {    this.textComment = textComment;
    }

    public User getUser() { return user; }
    public void setUser(User iduser) {  this.user = user;
    }

    public Date getDateComment() {  return dateComment; }
    public void setDateComment(Date dateComment) {    this.dateComment = dateComment;
    }

    public Comment_event() {
    }

    public Comment_event(Event event,String TitleComment, String textComment) {
        //this.event= event;
        this.TitleComment= TitleComment;
        this.textComment = textComment;
    }

    public Comment_event(Long idCmntEvent,Event event, String TitleComment, String textComment,User user) {
        this.idCmntEvent = idCmntEvent;
        //this.event= event;
        this.TitleComment = TitleComment;
        this.textComment = textComment;
        this.user =user;
    }

    @Override
    public String toString() {
        return "Comment_event{" +
                "idCmntBook=" +idCmntEvent +
      //          "event=" +event +
                ", TitleComment='" +TitleComment + '\'' +
                ", textComment='" + textComment + '\'' +
                ", author='" +user + '\'' +
                '}';
    }
}
