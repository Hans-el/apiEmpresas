package com.manabaware.api.service.impl;

import com.manabaware.api.dto.request.ServiceRequestDTO;
import com.manabaware.api.dto.response.ServiceResponseDTO;
import com.manabaware.api.exception.ResourceNotFoundException;
import com.manabaware.api.mapper.ServiceMapper;
import com.manabaware.api.model.Service;
import com.manabaware.api.repository.ServiceRepository;
import com.manabaware.api.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> findAllActive() {
        return serviceRepository.findByActiveTrue()
                .stream()
                .map(serviceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ServiceResponseDTO findById(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con id: " + id));
        return serviceMapper.toResponseDTO(service);
    }

    @Override
    @Transactional
    public ServiceResponseDTO create(ServiceRequestDTO dto) {
        Service service = serviceMapper.toEntity(dto);
        Service saved = serviceRepository.save(service);
        return serviceMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public ServiceResponseDTO update(Long id, ServiceRequestDTO dto) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con id: " + id));

        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setIcon(dto.getIcon());
        service.setUpdatedAt(LocalDateTime.now());

        Service updated = serviceRepository.save(service);
        return serviceMapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con id: " + id));
        serviceRepository.delete(service);
    }
}