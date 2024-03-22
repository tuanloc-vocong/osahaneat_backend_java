package com.tuanloc.osahaneat.service;

import com.tuanloc.osahaneat.dto.RestaurantDto;
import com.tuanloc.osahaneat.entity.RatingRestaurant;
import com.tuanloc.osahaneat.entity.Restaurant;
import com.tuanloc.osahaneat.repository.RestaurantRepository;
import com.tuanloc.osahaneat.service.impl.FileServiceImpl;
import com.tuanloc.osahaneat.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService implements RestaurantServiceImpl {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImpl fileServiceImpl;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeShip, String address, String open_date) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImpl.saveFile(file);
            if(isSaveFileSuccess){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDesc(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(isFreeShip);
                restaurant.setAddress(address);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
                Date openDate = simpleDateFormat.parse(open_date);
                restaurant.setOpenDate(openDate);
                restaurantRepository.save(restaurant);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant: " + e.getMessage());
        }
        return isInsertSuccess;
    }

    @Override
    public List<RestaurantDto> getHomePageRestaurant() {
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Restaurant> listData = restaurantRepository.findAll(pageRequest);

        for (Restaurant data : listData){
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setImage(data.getImage());
            restaurantDto.setTitle(data.getTitle());
            restaurantDto.setSubtitle(data.getSubtitle());
            restaurantDto.setFreeship(data.isFreeship());
            restaurantDto.setRating(calculatorRating(data.getListRatingRestaurant()));

            restaurantDtos.add(restaurantDto);
        }
        return restaurantDtos;
    }

    private double calculatorRating(Set<RatingRestaurant> listRating){
        double totalPoint = 0;
        for (RatingRestaurant data : listRating){
            totalPoint += data.getRatePoint();
        }
        return totalPoint / listRating.size();
    }
}
