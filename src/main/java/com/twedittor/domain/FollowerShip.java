package com.twedittor.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
@Entity
@Table(name = "followerShip", schema = "twedittor")
public class FollowerShip implements Serializable{

    @Id
    @ManyToOne
    private User follower;
    @Id
    @ManyToOne
    private User followee;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowee() {
        return followee;
    }

    public void setFollowee(User followee) {
        this.followee = followee;
    }
}
