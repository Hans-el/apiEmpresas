package com.manabaware.api.service.impl;

import com.manabaware.api.dto.request.ApplicationRequestDTO;
import com.manabaware.api.dto.response.ApplicationResponseDTO;
import com.manabaware.api.exception.ResourceNotFoundException;
import com.manabaware.api.mapper.ApplicationMapper;
import com.manabaware.api.model.Application;
import com.manabaware.api.model.JobOffer;
import com.manabaware.api.repository.ApplicationRepository;
import com.manabaware.api.repository.JobOfferRepository;
import com.manabaware.api.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobOfferRepository jobOfferRepository;
    private final ApplicationMapper applicationMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ApplicationResponseDTO> findByJobOfferId(Long jobOfferId) {
        return applicationRepository.findByJobOfferIdWithJobOffer(jobOfferId)
                .stream()
                .map(applicationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ApplicationResponseDTO create(ApplicationRequestDTO dto) {
        JobOffer jobOffer = jobOfferRepository.findById(dto.getJobOfferId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Oferta de empleo no encontrada con id: " + dto.getJobOfferId()));

        Application application = applicationMapper.toEntity(dto, jobOffer);
        Application saved = applicationRepository.save(application);
        return applicationMapper.toResponseDTO(saved);
    }
}