package com.manabaware.api.service;

import com.manabaware.api.dto.request.ServiceRequestDTO;
import com.manabaware.api.dto.response.ServiceResponseDTO;

import java.util.List;

public interface ServiceService {

    List<ServiceResponseDTO> findAllActive();

    ServiceResponseDTO findById(Long id);

    ServiceResponseDTO create(ServiceRequestDTO dto);

    ServiceResponseDTO update(Long id, ServiceRequestDTO dto);

    void delete(Long id);
}