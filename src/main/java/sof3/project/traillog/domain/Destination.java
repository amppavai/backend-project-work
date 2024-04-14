package sof3.project.traillog.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "destination_id")
    private Long destid;

    @Column(name = "destination_name")
    private String destName;

    @Column(name = "destination_description")
    private String destDescription;

    @Column(name = "destination_rating")
    private Double destRating;

    @ManyToMany(mappedBy = "destinations")
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Destination() {

    }

    public Destination(String destName, String destDescription, Double destRating) {
        super();
        this.destName = destName;
        this.destDescription = destDescription;
        this.destRating = destRating;
    }

    public Long getDestid() {
        return destid;
    }

    public void setDestid(Long destid) {
        this.destid = destid;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDestDescription() {
        return destDescription;
    }

    public void setDestDescription(String destDescription) {
        this.destDescription = destDescription;
    }

    public Double getDestRating() {
        return destRating;
    }

    public void setDestRating(Double destRating) {
        this.destRating = destRating;
    }

}
