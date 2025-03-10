package org.example.toyporj.DTO.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.toyporj.domain.Review;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RetrieveReview {
    private Double avgScore;
    private List<Review> reviews;
    private ReviewDtoPage page;

    @Data
    @Builder
    @AllArgsConstructor
    public static class ReviewDtoPage{
        private Integer offset;
        private Integer limit;
    }
}
