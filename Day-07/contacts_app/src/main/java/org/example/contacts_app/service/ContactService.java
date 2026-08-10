package org.example.contacts_app.service;


import org.example.contacts_app.dto.ContactRequestDTO;
import org.example.contacts_app.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    ContactResponseDTO createContact(
            ContactRequestDTO request
    );

    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);
}