package org.example.contacts_app.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDTO {

    private Long id;

    private String name;

    private String phone;

    private String email;
}