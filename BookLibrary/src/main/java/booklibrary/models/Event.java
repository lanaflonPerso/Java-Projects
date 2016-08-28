package booklibrary.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;

    @Column(nullable = false, length = 100)
    private String nameEvent;

    @Column(nullable = false, length = 700)
    private String aboutEvent;

    @Column(nullable = false, length = 100)
    private String placeEvent;

    @Column(nullable = false, length = 100)
    private String dateEvent;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    //@OneToMany(mappedBy = "event")
    //private Set<Comment_event> cmntevents = new HashSet<Comment_event>();

    @Column(nullable = false)
    private Date date= new Date();

    public Long getIdEvents() { return idEvent; }
    public void setIdEvents(Long idEvents) {    this.idEvent = idEvents;}

    public String getNameEvent() { return nameEvent; }
    public void setNameEvent(String nameEvent) {   this.nameEvent = nameEvent;}

    public String getAboutEvent() {return aboutEvent;  }
    public void setAboutEvent(String aboutEvent) { this.aboutEvent = aboutEvent;}

    public String getPlaceEvent() { return placeEvent;  }
    public void setPlaceEvent(String placeEvent) {   this.placeEvent = placeEvent;}

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category =category;}

    public User getUser() { return user; }
    public void setUser(User user) {  this.user = user;}

    public String getDateEvent() { return dateEvent;  }
    public void setDateEvent(String dateEvent) {    this.dateEvent = dateEvent;}

    public Date getDate() { return date;  }
    public void setDate(Date date) {   this.date = date;}

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    //public Set<Comment_event> getCmntevents() {
    //    return cmntevents;
    //}

    //public void setCmntevents(Set<Comment_event> cmntevents) {
    //    this.cmntevents = cmntevents;
    //}

    public Event() {
    }

    public Event(String TitleEvent, String textEvent) {
        this.nameEvent= TitleEvent;
        this.aboutEvent = textEvent;
    }

    public Event(Long idEvent, String TitleEvent, String textEvent,User user) {
        this.idEvent = idEvent;
        this.nameEvent = TitleEvent;
        this.aboutEvent = textEvent;
        this.user =user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", nameEvent='" + nameEvent + '\'' +
                ", aboutEvent='" + aboutEvent + '\'' +
                ", placeEvent='" + placeEvent + '\'' +
                ", dateEvent='" + dateEvent + '\'' +
                ", category=" + category +
                ", user=" + user +
      //          ", cmntevents=" + cmntevents +
                ", date=" + date +
                '}';
    }

}
