package com.manabaware.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ContactMessageResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private String subject;
    private String message;
    private Boolean read;
    private LocalDateTime createdAt;
}