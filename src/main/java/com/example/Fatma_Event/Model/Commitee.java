package com.example.Fatma_Event.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "commitee")
public class Commitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "commitee_name")
    private String commiteeName;

    @Column(name = "commite_position")
    private String commiteePosition;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommiteeName() {
        return commiteeName;
    }

    public void setCommiteeName(String commiteeName) {
        this.commiteeName = commiteeName;
    }

    public String getCommiteePosition() {
        return commiteePosition;
    }

    public void setCommiteePosition(String commiteePosition) {
        this.commiteePosition = commiteePosition;
    }
}


