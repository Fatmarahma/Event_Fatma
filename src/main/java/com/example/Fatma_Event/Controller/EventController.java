package com.example.Fatma_Event.Controller;

import com.example.Fatma_Event.Model.Commitee;
import com.example.Fatma_Event.Model.Event;
import com.example.Fatma_Event.Service.CommiteeService;
import com.example.Fatma_Event.Service.EventService;
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
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<Page<Event>> getAllEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<Event> events = eventService.getAllEvents(pageable);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
//        Optional<Event> existingEvent = eventService.getEventById(id);
//        if (existingEvent.isPresent()) {
//            event.setId(id);
//            Event updatedEvent = eventService.saveEvent(event);
//            return ResponseEntity.ok(updatedEvent);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Optional<Event> event = eventService.getEventById(id);

        if (event.isPresent()) {
            Event existingEvent = event.get();

            existingEvent.setTitle(eventDetails.getTitle());
            existingEvent.setStartOn(eventDetails.getStartOn());
            existingEvent.setCompleteOn(eventDetails.getCompleteOn());
            existingEvent.setParticipant(eventDetails.getParticipant());
            existingEvent.setLocation(eventDetails.getLocation());
            existingEvent.setCommitee(eventDetails.getCommitee());
            existingEvent.setVersion(eventDetails.getVersion());

            Event updatedEvent = eventService.saveEvent(existingEvent);

            return ResponseEntity.ok(updatedEvent);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "Event not found");
            return ResponseEntity.status(404).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Optional<Event> existingEvent = eventService.getEventById(id);
        if (existingEvent.isPresent()) {
            eventService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
