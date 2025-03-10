package org.example.toyporj.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateAndEditMenu {
    private final String name;
    private final Integer price;
}
