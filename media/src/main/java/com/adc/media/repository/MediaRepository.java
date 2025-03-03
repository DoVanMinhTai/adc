package com.adc.media.repository;

import com.adc.media.model.Media;
import com.adc.media.viewmodel.MediaVm;
import com.adc.media.viewmodel.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface MediaRepository extends JpaRepository<Media, Long> {

    @Query(value = "SELECT new com.adc.media.viewmodel.MetaData(m.id,m.caption,m.fileName,m.mediaType) from Media m WHERE m.id = ?1")
    MetaData findByIdWithoutFileInReturn(Long id);
}
