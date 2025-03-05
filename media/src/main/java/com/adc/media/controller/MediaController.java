package com.adc.media.controller;

import com.adc.media.model.dto.MediaDto;
import com.adc.media.service.MediaService;
import com.adc.media.viewmodel.MediaVm;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;

    @GetMapping("/medias/{id}")
    public ResponseEntity<MediaVm> getMediaById(@PathVariable Long id) {
        return ResponseEntity.ok(mediaService.getMediaById(id)  );
    }

    @GetMapping("/medias/{id}/file/{fileName}")
    public ResponseEntity<InputStreamResource> getFile(@Validated @org.springframework.web.bind.annotation.PathVariable("id") Long id, @org.springframework.web.bind.annotation.PathVariable("fileName") String fileName) {
        MediaDto mediaDto = mediaService.getFile(id, fileName);
        System.out.println(123);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + fileName + "\"").contentType(mediaDto.getMediaType()).body(
                new InputStreamResource(mediaDto.getContent()));
    }
}
