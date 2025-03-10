package org.example.toyporj.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.toyporj.DTO.CreateAndEditRestaurant;
import org.example.toyporj.domain.Menu;
import org.example.toyporj.domain.Restaurant;
import org.example.toyporj.repository.MenuRepository;
import org.example.toyporj.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public Restaurant createRestaurant(CreateAndEditRestaurant request) {
        Restaurant restaurant = Restaurant.
                builder()
                .name(request.name)
                .address(request.address)
                .createdDateTime(ZonedDateTime.now())
                .updatedDateTime(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurant);
        if(request.getMenus() == null) return restaurant;

        request.menus.forEach(menu -> {
            Menu menuItem = Menu.builder().name(menu.getName())
                    .restaurantId(restaurant.getId())
                    .price(menu.getPrice())
                    .createdDateTime(ZonedDateTime.now())
                    .updatedDateTime(ZonedDateTime.now()).build();
            menuRepository.save(menuItem);
        });
        return restaurant;
    }

    @Transactional
    public Restaurant editRestaurant(Long id, CreateAndEditRestaurant request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Not FoundException"));
        restaurant.editRestaurant(request.name, request.address);
        restaurantRepository.save(restaurant);

        List<Menu> menus = menuRepository.findAllByRestaurantId(id);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach(menu -> {
            Menu menuItem = Menu.builder()
                    .restaurantId(id)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdDateTime(ZonedDateTime.now())
                    .updatedDateTime(ZonedDateTime.now())
                    .build();
            menuRepository.save(menuItem);
        });
        return restaurant;
    }

    @Transactional
    public Restaurant deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Not FoundException"));

        menuRepository.deleteAll(menuRepository.findAllByRestaurantId(restaurant.getId()));
        restaurantRepository.deleteById(restaurant.getId());
        return restaurant;
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Not FoundException"));
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
