package com.mahmood.mediaapp;


import java.util.List;

public class User {
    private String userId;
    private String email;
    private List<String> following;

    public User() {}

    public User(String userId, String email, List<String> following) {
        this.userId = userId;
        this.email = email;
        this.following = following;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }
}
