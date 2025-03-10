package org.example.toyporj.DTO.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class RestaurantView {
    private final Long id;
    private final String name;
    private final String address;

    private final ZonedDateTime createdDateTime;
    private final ZonedDateTime updatedDateTime;

    private final List<Menu> menus;

    @Data
    @Builder
    @AllArgsConstructor
    public static class Menu{
        private final Long id;
        private final String name;
        private final Integer price;

        private final ZonedDateTime createdDateTime;
        private final ZonedDateTime updatedDateTime;
    }
}
