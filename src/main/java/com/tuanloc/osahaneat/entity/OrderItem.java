package com.tuanloc.osahaneat.entity;

import com.tuanloc.osahaneat.entity.key.KeyOrderItem;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "order_item")
public class OrderItem {
    @EmbeddedId
    KeyOrderItem keyOrderItem;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @Column(name = "created_date")
    private Date createdDate;
}
