package com.adc.media.service;

import com.adc.media.config.FileSystemConfig;
import com.adc.media.model.Media;
import com.adc.media.model.dto.MediaDto;
import com.adc.media.repository.FileSystemRepository;
import com.adc.media.repository.MediaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@lombok.RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final FileSystemConfig fileSystemConfig;
    private final FileSystemRepository fileSystemRepository;
    private final MediaRepository mediaRepository;
    @Override
    public MediaDto getFile(Long id, String fileName) {
        MediaDto.MediaDtoBuilder builder = MediaDto.builder();

        Media media = mediaRepository.findById(id).orElse(null);
        if (fileName.equalsIgnoreCase(media.getFileName()) || media == null) {
            return builder.build();
        }
        MediaType mediaType = MediaType.valueOf(media.getMediaType());
        InputStream fileContent = fileSystemRepository.getFile(media.getFilePath());
        return builder.content(fileContent).mediaType(mediaType).build();
    }


}
