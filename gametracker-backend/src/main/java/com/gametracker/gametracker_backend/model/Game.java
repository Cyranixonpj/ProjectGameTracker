package com.gametracker.gametracker_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name= "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String developer;
    private double rating;

    @Column(length = 1000)
    private String review;


    public Game() {
    }

    public Game(String title, String developer, double rating, String review) {
        this.title = title;
        this.developer = developer;
        this.rating = rating;
        this.review = review;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
}
