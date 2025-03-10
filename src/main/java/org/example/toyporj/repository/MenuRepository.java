package org.example.toyporj.repository;

import org.example.toyporj.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    public List<Menu> findAllByRestaurantId(Long restaurantId);
}
