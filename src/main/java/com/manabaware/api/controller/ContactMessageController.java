package com.manabaware.api.controller;

import com.manabaware.api.dto.request.ContactMessageRequestDTO;
import com.manabaware.api.dto.response.ContactMessageResponseDTO;
import com.manabaware.api.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @GetMapping
    public ResponseEntity<List<ContactMessageResponseDTO>> findAll() {
        return ResponseEntity.ok(contactMessageService.findAll());
    }

    @PostMapping
    public ResponseEntity<ContactMessageResponseDTO> create(@Valid @RequestBody ContactMessageRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactMessageService.create(dto));
    }
}