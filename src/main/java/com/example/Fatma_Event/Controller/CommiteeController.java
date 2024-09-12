package com.example.Fatma_Event.Controller;

import com.example.Fatma_Event.Model.Commitee;
import com.example.Fatma_Event.Service.CommiteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/commitee")
public class CommiteeController {

    @Autowired
    private CommiteeService commiteeService;

    // Get all commitees with pagination
    @GetMapping
    public ResponseEntity<Page<Commitee>> getAllCommitee(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<Commitee> commitees = commiteeService.getAllCommitee(pageable);
        return ResponseEntity.ok(commitees);
    }

    // Get commitee by id
    @GetMapping("/{id}")
    public ResponseEntity<Commitee> getCommiteeById(@PathVariable Long id) {
        Optional<Commitee> commitee = commiteeService.getCommiteeById(id);
        return commitee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new commitee
    @PostMapping
    public ResponseEntity<Commitee> createCommitee(@RequestBody Commitee commitee) {
        Commitee savedCommitee = commiteeService.saveCommitee(commitee);
        return ResponseEntity.ok(savedCommitee);
    }

    // Update existing commitee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCommitee(@PathVariable Long id, @RequestBody Commitee commiteeDetails) {
Optional<Commitee> commitee = commiteeService.getCommiteeById(id);

        if(commitee.isPresent()){
            Commitee existingCommitee = commitee.get();

            existingCommitee.setCommiteeName(commiteeDetails.getCommiteeName());
            existingCommitee.setCommiteePosition(commiteeDetails.getCommiteePosition()) ;

            Commitee updatedCommitee = commiteeService.saveCommitee(existingCommitee);

            // Kembalikan respons dengan event yang diupdate
            return ResponseEntity.ok(updatedCommitee);
        } else {
            // Jika event tidak ditemukan, kembalikan respons 404 untuk event
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "Event not found");
            return ResponseEntity.status(404).body(response);
        }
    }

    // Delete commitee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommitee(@PathVariable Long id) {
        if (!commiteeService.getCommiteeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        commiteeService.deleteCommitee(id);
        return ResponseEntity.noContent().build();
    }
}
