package com.manabaware.api.dto.response;

import com.manabaware.api.model.JobModality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class JobOfferResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private JobModality modality;
    private Boolean active;
    private LocalDateTime publishedAt;
    private LocalDateTime expiresAt;
}