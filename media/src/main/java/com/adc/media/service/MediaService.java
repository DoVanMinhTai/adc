package com.adc.media.service;

import com.adc.media.model.dto.MediaDto;
import com.adc.media.viewmodel.MediaVm;

public interface MediaService {

    MediaDto getFile(Long id, String fileName );

    MediaVm getMediaById(Long id);
}
