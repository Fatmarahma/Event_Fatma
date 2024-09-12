package com.example.Fatma_Event.Repository;


import com.example.Fatma_Event.Model.Commitee;
import com.sun.jdi.InterfaceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommiteeRepository extends JpaRepository<Commitee, Long> {

    // Method untuk pagination
    Page<Commitee> findAll(Pageable pageable);

}
