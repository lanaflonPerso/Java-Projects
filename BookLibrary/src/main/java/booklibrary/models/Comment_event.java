//package booklibrary.models;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "comments_events")
//public class Comment_event {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idCmntEvent;
//
//    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    // @JoinColumn(name="username",referencedColumnName = "username")
//    //@Column(nullable = false, length = 100)
//    private Event event;
//
//    @Column( length = 100)
//    private String TitleComment;
//
//    @Column( length = 500)
//    private String textComment;
//
//    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    // @JoinColumn(name="username",referencedColumnName = "username")
//    //@Column(nullable = false, length = 100)
//    private User user;
//
//    @Column(nullable = false)
//    private Date dateComment = new Date();
//    ///////////////////////////////////////////
//    //idCmntEvent
//    public Long getIdCmntEvent() { return idCmntEvent; }
//    public void setIdCmntEvent(Long idCmntEvent) {
//        this.idCmntEvent = idCmntEvent;
//    }
//    //idevent
//    public Event getEvent() { return event;  }
//    public void setEvent(Event event) {this.event = event;
//    }
//    //titlecom
//    public String getTitleComment() { return TitleComment;  }
//    public void setTitleComment(String titleComment) { TitleComment = titleComment;
//    }
//    //text
//    public String getTextComment() {  return textComment;  }
//    public void setTextComment(String textComment) {    this.textComment = textComment;
//    }
//    //user
//    public User getUser() { return user; }
//    public void setUser(User iduser) {  this.user = user;
//    }
//    //date
//    public Date getDateComment() {  return dateComment; }
//    public void setDateComment(Date dateComment) {    this.dateComment = dateComment;
//    }
//    ///////////////////////////////////////////////
//    public Comment_event() {
//    }
//
//    public Comment_event(Event event,String TitleComment, String textComment) {
//        this.event= event;
//        this.TitleComment= TitleComment;
//        this.textComment = textComment;
//    }
//
//    public Comment_event(Long idCmntEvent,Event event, String TitleComment, String textComment,User user) {
//        this.idCmntEvent = idCmntEvent;
//        this.event= event;
//        this.TitleComment = TitleComment;
//        this.textComment = textComment;
//        this.user =user;
//    }
//
//    @Override
//    public String toString() {
//        return "Comment_event{" +
//                "idCmntBook=" +idCmntEvent +
//                "event=" +event +
//                ", TitleComment='" +TitleComment + '\'' +
//                ", textComment='" + textComment + '\'' +
//                ", author='" +user + '\'' +
//                '}';
//    }
//
//}
