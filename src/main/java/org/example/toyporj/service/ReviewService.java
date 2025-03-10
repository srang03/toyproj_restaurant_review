package org.example.toyporj.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.toyporj.DTO.Review.CreateReview;
import org.example.toyporj.domain.Review;
import org.example.toyporj.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    // 리뷰 작성
    @Transactional
    public Review createReview(CreateReview request) {
        Review review = Review.builder()
                .restaurantId(request.restaurantId)
                .content(request.content)
                .createdDateTime(ZonedDateTime.now())
                .score(request.score).build();
        reviewRepository.save(review);
        return review;
    }

    // 리뷰 삭제
    @Transactional
    public Review deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Exception"));
        reviewRepository.delete(review);
        return review;
    }
    // 맛집 리뷰 전체 조회
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
