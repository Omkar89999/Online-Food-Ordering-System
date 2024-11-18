// package com.food.entity;

// import java.time.LocalDateTime;
// import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Data
// @Entity
// @Table(name = "order")
// public class Order {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @OneToMany(mappedBy = "order")
// private List<String> orderItems;

// private long userId;

// @Column(name = "orderStatus", nullable = false)
// private String orderStatus;

// @Column(name = "orderPrice", nullable = false)
// private double orderPrice;

// @Column(name = "orderDateTime", nullable = false)
// private LocalDateTime dateTime;
// }
