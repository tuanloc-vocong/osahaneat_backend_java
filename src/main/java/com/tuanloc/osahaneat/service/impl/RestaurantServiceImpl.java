package com.tuanloc.osahaneat.service.impl;

import org.springframework.web.multipart.MultipartFile;

public interface RestaurantServiceImpl {
    boolean insertRestaurant(
            MultipartFile file,
            String title,
            String subtitle,
            String description,
            boolean isFreeShip,
            String address,
            String openDate
    );
}
