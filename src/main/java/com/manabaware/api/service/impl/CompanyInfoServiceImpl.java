package com.manabaware.api.service.impl;

import com.manabaware.api.dto.request.CompanyInfoRequestDTO;
import com.manabaware.api.dto.response.CompanyInfoResponseDTO;
import com.manabaware.api.exception.ResourceNotFoundException;
import com.manabaware.api.mapper.CompanyInfoMapper;
import com.manabaware.api.model.CompanyInfo;
import com.manabaware.api.repository.CompanyInfoRepository;
import com.manabaware.api.service.CompanyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompanyInfoServiceImpl implements CompanyInfoService {

    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyInfoMapper companyInfoMapper;

    @Override
    @Transactional(readOnly = true)
    public CompanyInfoResponseDTO get() {
        CompanyInfo info = companyInfoRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Información de la empresa no configurada"));
        return companyInfoMapper.toResponseDTO(info);
    }

    @Override
    @Transactional
    public CompanyInfoResponseDTO update(CompanyInfoRequestDTO dto) {
        CompanyInfo info = companyInfoRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Información de la empresa no configurada"));
        companyInfoMapper.updateEntity(info, dto);
        info.setUpdatedAt(LocalDateTime.now());
        return companyInfoMapper.toResponseDTO(companyInfoRepository.save(info));
    }
}