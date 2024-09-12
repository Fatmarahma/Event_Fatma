package com.example.Fatma_Event.Service;


import com.example.Fatma_Event.Model.Participant;
import com.example.Fatma_Event.Repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public Page<Participant> getAllParticipants(Pageable pageable) {
        return participantRepository.findAll(pageable);
    }

    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
