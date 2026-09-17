package com.manabaware.api.repository;

import com.manabaware.api.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // findAll() y save() de JpaRepository ya son suficientes por ahora
}