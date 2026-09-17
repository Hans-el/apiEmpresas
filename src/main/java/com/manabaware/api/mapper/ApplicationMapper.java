package com.manabaware.api.mapper;

import com.manabaware.api.dto.request.ApplicationRequestDTO;
import com.manabaware.api.dto.response.ApplicationResponseDTO;
import com.manabaware.api.model.Application;
import com.manabaware.api.model.JobOffer;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public Application toEntity(ApplicationRequestDTO dto, JobOffer jobOffer) {
        Application app = new Application();
        app.setJobOffer(jobOffer);
        app.setApplicantName(dto.getApplicantName());
        app.setApplicantEmail(dto.getApplicantEmail());
        app.setResumeUrl(dto.getResumeUrl());
        return app;
    }

    public ApplicationResponseDTO toResponseDTO(Application app) {
        return new ApplicationResponseDTO(
                app.getId(),
                app.getJobOffer().getId(),
                app.getJobOffer().getTitle(),
                app.getApplicantName(),
                app.getApplicantEmail(),
                app.getResumeUrl(),
                app.getAppliedAt());
    }
}