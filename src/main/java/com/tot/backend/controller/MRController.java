package com.tot.backend.controller;

import com.tot.backend.dto.MediaDto;
import com.tot.backend.dto.ReviewDto;
import com.tot.backend.model.Media;
import com.tot.backend.model.Review;
import com.tot.backend.service.MediaService;
import com.tot.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Media and Review Controller
@RestController
public class MRController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addMedia")
    public Media addMedia(@RequestBody MediaDto mediaDto) {
        return mediaService.addMedia(mediaDto);
    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

}
