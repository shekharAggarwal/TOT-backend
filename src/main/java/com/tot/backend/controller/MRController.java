package com.tot.backend.controller;

import com.tot.backend.payload.request.MediaDto;
import com.tot.backend.payload.request.ReviewDto;
import com.tot.backend.model.Media;
import com.tot.backend.model.Review;
import com.tot.backend.service.MediaService;
import com.tot.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//Media and Review Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/mr")
@RestController
public class MRController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addMedia")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('USER')")
    public Media addMedia(@RequestBody MediaDto mediaDto) {
        return mediaService.addMedia(mediaDto);
    }

    @PostMapping("/addReview")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('USER')")
    public Review addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

}
