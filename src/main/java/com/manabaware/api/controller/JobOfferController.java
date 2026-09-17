package com.manabaware.api.controller;

import com.manabaware.api.dto.request.JobOfferRequestDTO;
import com.manabaware.api.dto.response.JobOfferResponseDTO;
import com.manabaware.api.service.JobOfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-offers")
@RequiredArgsConstructor
public class JobOfferController {

    private final JobOfferService jobOfferService;

    @GetMapping
    public ResponseEntity<List<JobOfferResponseDTO>> findAll() {
        return ResponseEntity.ok(jobOfferService.findAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobOfferResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(jobOfferService.findById(id));
    }

    @PostMapping
    public ResponseEntity<JobOfferResponseDTO> create(@Valid @RequestBody JobOfferRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobOfferService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobOfferResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody JobOfferRequestDTO dto) {
        return ResponseEntity.ok(jobOfferService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jobOfferService.delete(id);
        return ResponseEntity.noContent().build();
    }
}