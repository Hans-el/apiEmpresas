package com.manabaware.api.mapper;

import com.manabaware.api.dto.request.ServiceRequestDTO;
import com.manabaware.api.dto.response.ServiceResponseDTO;
import com.manabaware.api.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public Service toEntity(ServiceRequestDTO dto) {
        Service service = new Service();
        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setIcon(dto.getIcon());
        return service;
    }

    public ServiceResponseDTO toResponseDTO(Service service) {
        return new ServiceResponseDTO(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getIcon(),
                service.getActive(),
                service.getCreatedAt());
    }
}