package org.example.contacts_app.repository;

import org.example.contacts_app.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository
        extends JpaRepository<Contact, Long> {

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);
}