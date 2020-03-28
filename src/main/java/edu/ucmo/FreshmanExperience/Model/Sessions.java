package edu.ucmo.FreshmanExperience.Model;

import javax.persistence.*;
import java.util.Objects;

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

    public Sessions(String title, String location, String instructor){
        this.title = title;
        this.location = location;
        this.instructor = instructor;
    }

    public Sessions(){}

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
