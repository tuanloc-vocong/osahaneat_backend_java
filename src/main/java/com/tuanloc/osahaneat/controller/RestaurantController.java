package com.tuanloc.osahaneat.controller;

import com.tuanloc.osahaneat.payload.ResponseData;
import com.tuanloc.osahaneat.service.impl.FileServiceImpl;
import com.tuanloc.osahaneat.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImpl fileServiceImpl;

    @Autowired
    RestaurantServiceImpl restaurantServiceImpl;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam String description,
            @RequestParam boolean isFreeship,
            @RequestParam String address,
            @RequestParam String openDate){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = restaurantServiceImpl.insertRestaurant(file, title, subtitle, description, isFreeship, address, openDate);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename){
        Resource resource = fileServiceImpl.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping("")
    public ResponseEntity<?> getHomeRestaurant(){
        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceImpl.getHomePageRestaurant());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
