package ru.tsu.hits.curatorservice.dto.converter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tsu.hits.curatorservice.dto.CompanyDto;
import ru.tsu.hits.curatorservice.dto.CuratorDto;
import ru.tsu.hits.curatorservice.model.CuratorEntity;
import ru.tsu.hits.curatorservice.service.CompanyServiceClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CuratorDtoConverter {

    private final CompanyServiceClient companyServiceClient;

    public CuratorDto convertEntityToDto(CuratorEntity entity, HttpServletRequest request) {
        CuratorDto dto = new CuratorDto();
        dto.setId(entity.getId());
        dto.setCompanies(getCompanies(entity.getCompanyIds(), request));
        return dto;
    }

    private List<CompanyDto> getCompanies(List<String> companyIds, HttpServletRequest request) {
        return companyServiceClient.getCompanies(companyIds, request);
    }
}
