package com.manabaware.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyInfoRequestDTO {
    @NotBlank
    private String mission;
    @NotBlank
    private String vision;
    @NotBlank
    private String history;
    private Integer foundedYear;
    private String address;
    private Double latitude;
    private Double longitude;
}