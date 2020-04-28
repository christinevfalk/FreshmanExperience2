package edu.ucmo.FreshmanExperience.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sessions")
public class Sessions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String location;
    @Column
    private String instructor;
    @Column
    private Date date1;
    @Column
    private Time time1;


    public Sessions(String title, String location, String instructor, Date date1, Time time1){
        this.title = title;
        this.location = location;
        this.instructor = instructor;
        this.date1 = date1;
        this.time1 = time1;
    }

    public Sessions(){}

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "session_attendance", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "user_name"))

    private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 =time1;
    }

    public Set<User> getUsers(){
        return users;
    }
    public void setUsers(Set<User> users){
        this.users = users;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, location, instructor);
    }

    @Override
    public String toString(){
        return "Sessions{"  +
                "id=" + id +
                ", Session Title = " + title +'\'' +
                ", Session Location = " + location + '\'' +
                ", Session Instructor = " + instructor + '\'' +
                '}';
    }
}
