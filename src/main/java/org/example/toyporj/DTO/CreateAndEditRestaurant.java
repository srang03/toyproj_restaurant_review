package org.example.toyporj.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class CreateAndEditRestaurant {
    public final String name;
    public final String address;
    public final List<CreateAndEditMenu> menus;
}
