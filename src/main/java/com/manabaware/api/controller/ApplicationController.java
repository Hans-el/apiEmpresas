package com.manabaware.api.controller;

import com.manabaware.api.dto.request.ApplicationRequestDTO;
import com.manabaware.api.dto.response.ApplicationResponseDTO;
import com.manabaware.api.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/job-offer/{jobOfferId}")
    public ResponseEntity<List<ApplicationResponseDTO>> findByJobOffer(@PathVariable Long jobOfferId) {
        return ResponseEntity.ok(applicationService.findByJobOfferId(jobOfferId));
    }

    @PostMapping
    public ResponseEntity<ApplicationResponseDTO> create(@Valid @RequestBody ApplicationRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.create(dto));
    }
}