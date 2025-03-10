package org.example.toyporj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Restaurant {
    private final String name;
    private final String address;

    private final List<Menu> menus;
}
