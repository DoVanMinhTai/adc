package com.adc.location.service;

import com.adc.location.mapper.CountryMapper;
import com.adc.location.repository.CountryRepository;
import com.adc.location.viewmodel.country.CountryListGetVm;
import com.adc.location.viewmodel.country.CountryVm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Transactional(readOnly = true)
    public List<CountryVm> listAllCountry() {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC,"name"))
                .stream()
                .map(countryMapper::toCountryViewModelFromCountry).toList();
    }

    public CountryListGetVm getPageableCountries(int pageNo, int pageSize) {
    }
}
