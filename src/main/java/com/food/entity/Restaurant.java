package com.food.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RestaurantName", nullable = false)
    private String restaurantName;

    @Embedded
    private Location location;

    @Column(name = "Description", nullable = true)
    private String description;

    @Column(name = "Rating", nullable = false)
    private Float rating;

    @JsonBackReference
    @OneToMany(mappedBy = "restaurant")
    private List<MenuItem> menuItems;

    public Restaurant(String description, Location location, Float rating, String restaurantName,
            List<MenuItem> menuItems) {
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.restaurantName = restaurantName;
        this.menuItems = menuItems;
    }

}
