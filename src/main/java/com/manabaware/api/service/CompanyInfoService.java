package com.manabaware.api.service;

import com.manabaware.api.dto.request.CompanyInfoRequestDTO;
import com.manabaware.api.dto.response.CompanyInfoResponseDTO;

public interface CompanyInfoService {
    CompanyInfoResponseDTO get();

    CompanyInfoResponseDTO update(CompanyInfoRequestDTO dto);
}