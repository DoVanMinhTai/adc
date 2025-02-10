package com.adc.media.service;

import com.adc.media.model.dto.MediaDto;

public interface MediaService {

    MediaDto getFile(Long id, String fileName );
}
