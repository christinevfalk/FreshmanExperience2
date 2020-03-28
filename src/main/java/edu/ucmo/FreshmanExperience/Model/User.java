package edu.ucmo.FreshmanExperience.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
   @Column(name = "user_id")
    private String ucmoId;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUcmoId() {
        return ucmoId;
    }
    public void setUcmoId(String ucmoId) {
        this.ucmoId = ucmoId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Set<Role> getRoles(){
        return roles;
    }
    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    @Override
    public String toString(){
        return "User{"  +
                "UCMO id=" + ucmoId +
                ", First Name = " + fname +'\'' +
                ", Last Name = " + lname + '\'' +
                ", Email = " + email + '\'';
    }
}