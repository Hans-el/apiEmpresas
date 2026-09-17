package com.manabaware.api.mapper;

import com.manabaware.api.dto.request.JobOfferRequestDTO;
import com.manabaware.api.dto.response.JobOfferResponseDTO;
import com.manabaware.api.model.JobOffer;
import org.springframework.stereotype.Component;

@Component
public class JobOfferMapper {

    public JobOffer toEntity(JobOfferRequestDTO dto) {
        JobOffer offer = new JobOffer();
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setLocation(dto.getLocation());
        offer.setModality(dto.getModality());
        offer.setExpiresAt(dto.getExpiresAt());
        return offer;
    }

    public JobOfferResponseDTO toResponseDTO(JobOffer offer) {
        return new JobOfferResponseDTO(
                offer.getId(),
                offer.getTitle(),
                offer.getDescription(),
                offer.getLocation(),
                offer.getModality(),
                offer.getActive(),
                offer.getPublishedAt(),
                offer.getExpiresAt());
    }
}