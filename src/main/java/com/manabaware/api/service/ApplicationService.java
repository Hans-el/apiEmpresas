package com.manabaware.api.service;

import com.manabaware.api.dto.request.ApplicationRequestDTO;
import com.manabaware.api.dto.response.ApplicationResponseDTO;

import java.util.List;

public interface ApplicationService {
    List<ApplicationResponseDTO> findByJobOfferId(Long jobOfferId);

    ApplicationResponseDTO create(ApplicationRequestDTO dto);
}