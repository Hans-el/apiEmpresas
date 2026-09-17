package com.manabaware.api.dto.request;

import com.manabaware.api.model.JobModality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class JobOfferRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotBlank(message = "La ubicación es obligatoria")
    private String location;

    @NotNull(message = "La modalidad es obligatoria")
    private JobModality modality;

    private LocalDateTime expiresAt;
}