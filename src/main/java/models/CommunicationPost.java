// src/main/java/model/CommunicationPost.java

package models;

import java.util.Date;

public class CommunicationPost {
    private int id;
    private String title;
    private String content;
    private String author;
    private Date createdDate;
    private int views;
    private String category;

    // 생성자
    public CommunicationPost() {}

    public CommunicationPost(int id, String title, String content, String author, Date createdDate, int views, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.views = views;
        this.category = category;
    }

    // Getter와 Setter 메소드
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 게시물의 요약 정보 반환
    @Override
    public String toString() {
        return "CommunicationPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createdDate=" + createdDate +
                ", views=" + views +
                ", category='" + category + '\'' +
                '}';
    }
}
