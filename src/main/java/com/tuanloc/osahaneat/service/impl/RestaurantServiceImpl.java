package com.tuanloc.osahaneat.service.impl;

import com.tuanloc.osahaneat.dto.RestaurantDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    List<RestaurantDto> getHomePageRestaurant();
}
