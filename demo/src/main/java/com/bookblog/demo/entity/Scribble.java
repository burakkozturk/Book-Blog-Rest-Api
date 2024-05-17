package com.bookblog.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "scribble")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scribble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = true)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = true)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "referencedScribbleId", nullable = true)
    private Scribble referencedScribble;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    // Constructor for creating a Scribble with content and user
    public Scribble(String content, User user) {
        this.content = content;
        this.user = user;
    }

    // Constructor for creating a Scribble with content, user, and book
    public Scribble(String content, User user, Book book) {
        this.content = content;
        this.user = user;
        this.book = book;
    }

    // Constructor for creating a Scribble with content, user, and author
    public Scribble(String content, User user, Author author) {
        this.content = content;
        this.user = user;
        this.author = author;
    }

    // Constructor for creating a Scribble with content, user, and referenced Scribble
    public Scribble(String content, User user, Scribble referencedScribble) {
        this.content = content;
        this.user = user;
        this.referencedScribble = referencedScribble;
    }
}
