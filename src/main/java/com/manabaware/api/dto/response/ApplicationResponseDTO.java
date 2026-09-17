package com.manabaware.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApplicationResponseDTO {
    private Long id;
    private Long jobOfferId;
    private String jobOfferTitle; // resumen útil, sin traer el objeto completo
    private String applicantName;
    private String applicantEmail;
    private String resumeUrl;
    private LocalDateTime appliedAt;
}