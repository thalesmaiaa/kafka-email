package org.example.simpleemail.email;

import jakarta.persistence.*;


@Entity
@Table(name = "email")

public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subject;
    private String body;
    private String to;
    public Email(Long id, String title, String subject, String body, String to) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.body = body;
        this.to = to;
    }

    public Email() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Email(String title, String subject, String body) {
        this.title = title;
        this.subject = subject;
        this.body = body;
    }
}
