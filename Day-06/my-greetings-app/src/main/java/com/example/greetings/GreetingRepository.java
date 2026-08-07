package com.example.greetings;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
