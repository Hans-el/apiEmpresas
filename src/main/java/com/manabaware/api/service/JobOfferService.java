package com.manabaware.api.service;

import com.manabaware.api.dto.request.JobOfferRequestDTO;
import com.manabaware.api.dto.response.JobOfferResponseDTO;

import java.util.List;

public interface JobOfferService {
    List<JobOfferResponseDTO> findAllActive();

    JobOfferResponseDTO findById(Long id);

    JobOfferResponseDTO create(JobOfferRequestDTO dto);

    JobOfferResponseDTO update(Long id, JobOfferRequestDTO dto);

    void delete(Long id);
}