package com.thebigcourses.personalblogapp.Model;

public class PostList {
    public String postID;
    public String postTitle;
    public String postImageUrl;
    public String postDescription;

    public PostList() {
    }

    public PostList(String postID, String postTitle, String postImageUrl, String postDescription) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postImageUrl = postImageUrl;
        this.postDescription = postDescription;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }
}
