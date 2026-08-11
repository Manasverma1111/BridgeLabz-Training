package org.example.contacts_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "contacts",
        indexes = {
                @Index(
                        name = "idx_contact_name",
                        columnList = "name"
                )
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_contact_phone",
                        columnNames = "phone"
                ),
                @UniqueConstraint(
                        name = "uk_contact_email",
                        columnNames = "email"
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            length = 50
    )
    private String name;

    @Column(
            name = "phone",
            nullable = false,
            length = 10
    )
    private String phone;

    @Column(
            name = "email",
            nullable = false,
            length = 100
    )
    private String email;
}