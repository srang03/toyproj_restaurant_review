package org.example.toyporj.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.toyporj.DTO.Review.CreateReview;
import org.example.toyporj.domain.Review;
import org.example.toyporj.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public Review createReview(@RequestBody CreateReview review) {
        return reviewService.createReview(review);
    }

    @DeleteMapping("/reviews/{id}")
    public Review deleteReview(@PathVariable Long id) {
        return reviewService.deleteReview(id);
    }

    @GetMapping("/reviews")
    public List<Review> findAll() {
        return reviewService.findAll();
    }


}
