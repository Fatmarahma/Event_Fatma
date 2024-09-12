package com.example.Fatma_Event.Repository;

import com.example.Fatma_Event.Model.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Page<Participant> findAll (Pageable pageable);

    List<Participant> findByEventId(Long eventId);
}