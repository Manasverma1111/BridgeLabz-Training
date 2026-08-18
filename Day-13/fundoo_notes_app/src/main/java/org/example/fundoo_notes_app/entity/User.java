package org.example.fundoo_notes_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String passwordHash;

    private String name;

    // Day 14: Authorization - every user has a role, embedded as a claim in
    // the JWT and mapped to a Spring Security GrantedAuthority.
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role = Role.USER;

    // Day 14: JPA deep-dive - real entity relationship instead of a raw
    // userId foreign-key field. cascade+orphanRemoval keeps notes in sync
    // when a user is deleted.
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Note> notes = new ArrayList<>();

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public List<Note> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(List<Note> notes) {
//        this.notes = notes;
//    }
}
