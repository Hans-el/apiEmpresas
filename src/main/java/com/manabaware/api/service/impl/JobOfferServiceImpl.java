package com.manabaware.api.service.impl;

import com.manabaware.api.dto.request.JobOfferRequestDTO;
import com.manabaware.api.dto.response.JobOfferResponseDTO;
import com.manabaware.api.exception.ResourceNotFoundException;
import com.manabaware.api.mapper.JobOfferMapper;
import com.manabaware.api.model.JobOffer;
import com.manabaware.api.repository.JobOfferRepository;
import com.manabaware.api.service.JobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobOfferServiceImpl implements JobOfferService {

    private final JobOfferRepository jobOfferRepository;
    private final JobOfferMapper jobOfferMapper;

    @Override
    @Transactional(readOnly = true)
    public List<JobOfferResponseDTO> findAllActive() {
        return jobOfferRepository.findByActiveTrueAndExpiresAtAfterOrExpiresAtIsNull(LocalDateTime.now())
                .stream()
                .map(jobOfferMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public JobOfferResponseDTO findById(Long id) {
        JobOffer offer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta de empleo no encontrada con id: " + id));
        return jobOfferMapper.toResponseDTO(offer);
    }

    @Override
    @Transactional
    public JobOfferResponseDTO create(JobOfferRequestDTO dto) {
        JobOffer offer = jobOfferMapper.toEntity(dto);
        return jobOfferMapper.toResponseDTO(jobOfferRepository.save(offer));
    }

    @Override
    @Transactional
    public JobOfferResponseDTO update(Long id, JobOfferRequestDTO dto) {
        JobOffer offer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta de empleo no encontrada con id: " + id));
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setLocation(dto.getLocation());
        offer.setModality(dto.getModality());
        offer.setExpiresAt(dto.getExpiresAt());
        return jobOfferMapper.toResponseDTO(jobOfferRepository.save(offer));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        JobOffer offer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta de empleo no encontrada con id: " + id));
        jobOfferRepository.delete(offer);
    }
}