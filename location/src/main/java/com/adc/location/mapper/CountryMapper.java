package com.adc.location.mapper;

import com.adc.location.model.Country;
import com.adc.location.viewmodel.country.CountryVm;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryMapper {
    CountryVm toCountryViewModelFromCountry(Country country);
}
