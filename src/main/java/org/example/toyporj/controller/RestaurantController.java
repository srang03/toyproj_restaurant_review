package org.example.toyporj.controller;

import org.example.toyporj.domain.Restaurant;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public String retrieveRestaurant() {
        return "retrieveRestaurant";
    }

    @GetMapping("/restaurants/{id}")
    public String retrieveRestaurantById(@PathVariable Long id) {
        return "retrieveRestaurantById: " + id;
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurant;
    }

    @PutMapping("/restaurants/{id}")
    public String updateRestaurantById(@PathVariable Long id){
        return "updateRestaurantById: "+ id;
    }

    @DeleteMapping("/restaurants/{id}")
    public String deleteRestaurantById(@PathVariable Long id) {
        return "deleteRestaurantById: " + id;
    }
}
