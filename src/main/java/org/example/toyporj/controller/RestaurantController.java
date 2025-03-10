package org.example.toyporj.controller;

import lombok.AllArgsConstructor;
import org.example.toyporj.DTO.Restaurant.CreateAndEditRestaurant;
import org.example.toyporj.DTO.Restaurant.RestaurantView;
import org.example.toyporj.domain.Restaurant;
import org.example.toyporj.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

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
}
