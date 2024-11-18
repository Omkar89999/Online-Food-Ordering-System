package com.food.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "Rating", nullable = true)
    private String rating;

    public Restaurant(String description, Location location, String rating, String restaurantName) {
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.restaurantName = restaurantName;
    }

}
