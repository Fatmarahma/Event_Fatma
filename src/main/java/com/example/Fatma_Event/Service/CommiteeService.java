package com.example.Fatma_Event.Service;

import com.example.Fatma_Event.Model.Commitee;
import com.example.Fatma_Event.Repository.CommiteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommiteeService {

    @Autowired
    private CommiteeRepository commiteeRepository;

    public Optional<Commitee> getCommiteeById(Long id) {
        return commiteeRepository.findById(id);
    }

    public Page<Commitee> getAllCommitee(Pageable pageable) {

        return commiteeRepository.findAll(pageable);
    }

    public Commitee saveCommitee(Commitee commitee) {
        return commiteeRepository.save(commitee);
    }

    public void deleteCommitee(Long id) {
        commiteeRepository.deleteById(id);
    }
}

