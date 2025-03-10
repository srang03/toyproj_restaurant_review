package org.example.toyporj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Table(name = "restaurant")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createdDateTime;
    private ZonedDateTime updatedDateTime;
    // private List<Menu> menus;

    public void editRestaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.updatedDateTime = ZonedDateTime.now();
    }
}
