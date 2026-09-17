package com.manabaware.api.controller;

import com.manabaware.api.dto.request.CompanyInfoRequestDTO;
import com.manabaware.api.dto.response.CompanyInfoResponseDTO;
import com.manabaware.api.service.CompanyInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company-info")
@RequiredArgsConstructor
public class CompanyInfoController {

    private final CompanyInfoService companyInfoService;

    @GetMapping
    public ResponseEntity<CompanyInfoResponseDTO> get() {
        return ResponseEntity.ok(companyInfoService.get());
    }

    @PutMapping
    public ResponseEntity<CompanyInfoResponseDTO> update(@Valid @RequestBody CompanyInfoRequestDTO dto) {
        return ResponseEntity.ok(companyInfoService.update(dto));
    }
}