package com.example.Fatma_Event.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_on", nullable = false)
    private LocalDateTime startOn;

    @Column(name = "complete_on", nullable = false)
    private LocalDateTime completeOn;

    @Column(name = "participant", nullable = false)
    private Integer participant;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "version")
    private Integer version;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commitee_id")
    private Commitee commitee;

    // Default constructor
    public Event() {
    }


    public Event(String title, LocalDateTime startOn, LocalDateTime completeOn,
                 Integer participant, String location, Integer version, Commitee commitee) {
        if (completeOn != null && startOn != null && !completeOn.isAfter(startOn)) {
            throw new IllegalArgumentException("Complete must be after start");
        }
        this.title = title;
        this.startOn = startOn;
        this.completeOn = completeOn;
        this.participant = participant;
        this.location = location;
        this.version = version;
        this.commitee = commitee;
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

    public LocalDateTime getStartOn() {
        return startOn;
    }

    public void setStartOn(LocalDateTime startOn) {
        this.startOn = startOn;
    }

    public LocalDateTime getCompleteOn() {
        return completeOn;
    }

    public void setCompleteOn(LocalDateTime completeOn) {
        if (completeOn != null && startOn != null && !completeOn.isAfter(startOn)) {
            throw new IllegalArgumentException("Complete must be after start");
        }
        this.completeOn = completeOn;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Commitee getCommitee() {
        return commitee;
    }

    public void setCommitee(Commitee commitee) {
        this.commitee = commitee;
    }
}
