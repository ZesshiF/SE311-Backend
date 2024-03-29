package se311.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se311.lab.rest.entity.Event;
import se311.lab.rest.entity.Organizer;
import se311.lab.rest.service.EventService;
import se311.lab.rest.service.OrganizerService;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {

    final OrganizerService organizerService;

    @GetMapping("organizers")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                           @RequestParam(value = "_page", required = false) Integer page) {
        List<Organizer> output = null;
        Integer organizeSize = organizerService.getOrganizeSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(organizeSize));
        try {
            output = organizerService.getOrganizers(perPage, page);
            return new
                    ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return new
                    ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        }
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganize(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganize(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}


