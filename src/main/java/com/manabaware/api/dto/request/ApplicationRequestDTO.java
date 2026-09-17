package com.manabaware.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequestDTO {

    @NotNull(message = "El id de la oferta es obligatorio")
    private Long jobOfferId;

    @NotBlank(message = "El nombre es obligatorio")
    private String applicantName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    private String applicantEmail;

    private String resumeUrl;
}