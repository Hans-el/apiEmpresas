package com.manabaware.api.service;

import com.manabaware.api.dto.request.ContactMessageRequestDTO;
import com.manabaware.api.dto.response.ContactMessageResponseDTO;

import java.util.List;

public interface ContactMessageService {
    List<ContactMessageResponseDTO> findAll();

    ContactMessageResponseDTO create(ContactMessageRequestDTO dto);

    ContactMessageResponseDTO markAsRead(Long id);
}