package com.manabaware.api.mapper;

import com.manabaware.api.dto.request.CompanyInfoRequestDTO;
import com.manabaware.api.dto.response.CompanyInfoResponseDTO;
import com.manabaware.api.model.CompanyInfo;
import org.springframework.stereotype.Component;

@Component
public class CompanyInfoMapper {

    public CompanyInfoResponseDTO toResponseDTO(CompanyInfo info) {
        return new CompanyInfoResponseDTO(
                info.getId(), info.getMission(), info.getVision(),
                info.getHistory(), info.getFoundedYear(), info.getUpdatedAt(), info.getAddress(), info.getLatitude(),
                info.getLongitude());
    }

    public void updateEntity(CompanyInfo info, CompanyInfoRequestDTO dto) {
        info.setMission(dto.getMission());
        info.setVision(dto.getVision());
        info.setHistory(dto.getHistory());
        info.setFoundedYear(dto.getFoundedYear());
        info.setAddress(dto.getAddress());
        info.setLatitude(dto.getLatitude());
        info.setLongitude(dto.getLongitude());
    }
}