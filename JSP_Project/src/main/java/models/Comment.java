package models;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private String author;
    private int postId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

	public void setDate(LocalDateTime localDateTime) {
		// TODO Auto-generated method stub
		
	}
}
