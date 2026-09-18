package com.manabaware.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CompanyInfoResponseDTO {
    private Long id;
    private String mission;
    private String vision;
    private String history;
    private Integer foundedYear;
    private LocalDateTime updatedAt;
    private String address;
    private Double latitude;
    private Double longitude;
}