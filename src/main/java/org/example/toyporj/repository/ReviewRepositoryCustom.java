package org.example.toyporj.repository;

import org.example.toyporj.domain.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewRepositoryCustom {
    Double getAvgSocreByRestaurantId(Long restaurantId);
    Slice<Review> findSliceByRestaurantId(Long restaurantId, Pageable pageable);
}
