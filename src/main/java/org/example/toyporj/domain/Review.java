package org.example.toyporj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Table(name="Review")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long restaurantId;
    private String content;
    private Double score;
    private ZonedDateTime createdDateTime;
}
