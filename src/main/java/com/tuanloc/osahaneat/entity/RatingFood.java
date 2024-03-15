package com.tuanloc.osahaneat.entity;

import jakarta.persistence.*;

@Entity(name = "rating_food")
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "content")
    private String content;

    @Column(name = "rate_point")
    private int ratePoint;
}
