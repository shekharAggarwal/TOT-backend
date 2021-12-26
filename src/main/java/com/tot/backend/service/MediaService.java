package com.tot.backend.service;

import com.tot.backend.dto.MediaDto;
import com.tot.backend.model.Media;
import com.tot.backend.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public Media addMedia(MediaDto mediaDto) {
        Media media = new Media();
        return mediaRepository.save(media);
    }
}
