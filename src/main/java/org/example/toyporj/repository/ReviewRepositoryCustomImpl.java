package org.example.toyporj.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.toyporj.domain.QReview;
import org.example.toyporj.domain.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Double getAvgSocreByRestaurantId(Long restaurantId) {
        return jpaQueryFactory.select(QReview.review.score.avg()).from(QReview.review)
                .where(QReview.review.restaurantId.eq(restaurantId)).fetchFirst();
    }

    @Override
    public Slice<Review> findSliceByRestaurantId(Long restaurantId, Pageable page) {
        List<Review> reviews = jpaQueryFactory.select(QReview.review)
                .from(QReview.review)
                .where(QReview.review.restaurantId.eq(restaurantId))
                .offset((long) page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize() + 1).fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()
        );
    }
}
