package org.example.contacts_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.contacts_app.dto.ContactRequestDTO;
import org.example.contacts_app.dto.ContactResponseDTO;
import org.example.contacts_app.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    // CREATE
    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(
            @Valid @RequestBody ContactRequestDTO request) {

        ContactResponseDTO response = contactService.createContact(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>>
    getAllContacts() {

        return ResponseEntity.ok(
                contactService.getAllContacts()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO>
    getContactById(@PathVariable Long id) {

        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }
}