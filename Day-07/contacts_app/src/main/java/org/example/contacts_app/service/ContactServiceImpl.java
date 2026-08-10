package org.example.contacts_app.service;

import lombok.RequiredArgsConstructor;
import org.example.contacts_app.dto.ContactRequestDTO;
import org.example.contacts_app.dto.ContactResponseDTO;
import org.example.contacts_app.entity.Contact;
import org.example.contacts_app.exception.ContactAlreadyExistsException;
import org.example.contacts_app.exception.ContactNotFoundException;
import org.example.contacts_app.repository.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactResponseDTO createContact(
            ContactRequestDTO request) {

        // Check duplicate phone
        if (contactRepository.existsByPhone(request.getPhone())) {

            throw new ContactAlreadyExistsException(
                    "Phone number already exists: "
                            + request.getPhone()
            );
        }

        // Check duplicate email
        if (contactRepository.existsByEmail(request.getEmail())) {

            throw new ContactAlreadyExistsException(
                    "Email already exists: "
                            + request.getEmail()
            );
        }

        Contact contact = Contact.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();

        Contact savedContact =
                contactRepository.save(contact);

        return mapToResponseDTO(savedContact);
    }

    @Override
    public List<ContactResponseDTO> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public ContactResponseDTO getContactById(Long id) {

        Contact contact = contactRepository
                .findById(id)
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with id: " + id
                        )
                );

        return mapToResponseDTO(contact);
    }

    private ContactResponseDTO mapToResponseDTO(
            Contact contact) {

        return ContactResponseDTO.builder()
                .id(contact.getId())
                .name(contact.getName())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .build();
    }
}