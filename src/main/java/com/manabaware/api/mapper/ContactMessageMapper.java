package com.manabaware.api.mapper;

import com.manabaware.api.dto.request.ContactMessageRequestDTO;
import com.manabaware.api.dto.response.ContactMessageResponseDTO;
import com.manabaware.api.model.ContactMessage;
import org.springframework.stereotype.Component;

@Component
public class ContactMessageMapper {

    public ContactMessage toEntity(ContactMessageRequestDTO dto) {
        ContactMessage msg = new ContactMessage();
        msg.setFullName(dto.getFullName());
        msg.setEmail(dto.getEmail());
        msg.setSubject(dto.getSubject());
        msg.setMessage(dto.getMessage());
        return msg;
    }

    public ContactMessageResponseDTO toResponseDTO(ContactMessage msg) {
        return new ContactMessageResponseDTO(
                msg.getId(),
                msg.getFullName(),
                msg.getEmail(),
                msg.getSubject(),
                msg.getMessage(),
                msg.getRead(),
                msg.getCreatedAt());
    }
}