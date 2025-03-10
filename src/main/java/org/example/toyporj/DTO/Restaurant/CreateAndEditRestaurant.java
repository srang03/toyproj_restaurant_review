package org.example.toyporj.DTO.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CreateAndEditRestaurant {
    public final String name;
    public final String address;
    public final List<CreateAndEditMenu> menus;
}
