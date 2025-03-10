package org.example.toyporj.controller;

import lombok.AllArgsConstructor;
import org.example.toyporj.DTO.Restaurant.CreateAndEditRestaurant;
import org.example.toyporj.DTO.Restaurant.RestaurantView;
import org.example.toyporj.DTO.Review.RetrieveReview;
import org.example.toyporj.domain.Restaurant;
import org.example.toyporj.service.RestaurantService;
import org.example.toyporj.service.ReviewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody CreateAndEditRestaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{id}")
    public Restaurant updateRestaurantById(@PathVariable Long id, @RequestBody CreateAndEditRestaurant request) {
        return restaurantService.editRestaurant(id, request);
    }

    @DeleteMapping("/restaurants/{id}")
    public Restaurant deleteRestaurantById(@PathVariable Long id) {
        return restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/restaurants/{id}")
    public RestaurantView getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/restaurants")
    public List<RestaurantView> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}/reviews")
    public RetrieveReview getAllReviewsByRestaurantId(@PathVariable Long restaurantId,
                                                      @RequestParam("offset") Integer offset,
                                                      @RequestParam("limit") Integer limit) {
        return reviewService.getRestaurantReview(restaurantId, PageRequest.of(offset/limit, limit));
    }
}
