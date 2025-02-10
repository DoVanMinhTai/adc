package com.adc.media.viewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaVm {
    private Long id;
    private String caption;
    private String fileName;
    private String filePath;
    private String mediaType;

    public MediaVm(Long id, String caption, String fileName, String filePath, String mediaType) {
        this.id = id;
        this.caption = caption;
        this.fileName = fileName;
        this.filePath = filePath;
        this.mediaType = mediaType;
    }
}
