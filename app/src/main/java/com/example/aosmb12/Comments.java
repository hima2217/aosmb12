package com.example.aosmb12;

public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comments(){}

    public Comments (int postId, String email){
        this.postId = postId;
        this.email=email;
    }
    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

