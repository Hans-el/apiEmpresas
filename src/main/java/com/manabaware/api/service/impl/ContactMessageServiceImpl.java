package com.manabaware.api.service.impl;

import com.manabaware.api.dto.request.ContactMessageRequestDTO;
import com.manabaware.api.dto.response.ContactMessageResponseDTO;
import com.manabaware.api.exception.ResourceNotFoundException;
import com.manabaware.api.mapper.ContactMessageMapper;
import com.manabaware.api.model.ContactMessage;
import com.manabaware.api.repository.ContactMessageRepository;
import com.manabaware.api.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ContactMessageResponseDTO> findAll() {
        return contactMessageRepository.findAll()
                .stream()
                .map(contactMessageMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ContactMessageResponseDTO create(ContactMessageRequestDTO dto) {
        ContactMessage msg = contactMessageMapper.toEntity(dto);
        return contactMessageMapper.toResponseDTO(contactMessageRepository.save(msg));
    }

    @Override
    @Transactional
    public ContactMessageResponseDTO markAsRead(Long id) {
        ContactMessage msg = contactMessageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrado con id: " + id));
        msg.setRead(true);
        return contactMessageMapper.toResponseDTO(contactMessageRepository.save(msg));
    }
}