package org.example.toyporj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Menu {
    private final String name;
    private final Integer price;
}
