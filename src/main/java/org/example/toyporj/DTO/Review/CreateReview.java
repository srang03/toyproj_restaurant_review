package org.example.toyporj.DTO.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReview {
    public final Long restaurantId;
    public final String content;
    public final Double score;
}
