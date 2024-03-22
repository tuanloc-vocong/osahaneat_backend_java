package com.tuanloc.osahaneat.controller;

import com.tuanloc.osahaneat.payload.ResponseData;
import com.tuanloc.osahaneat.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuServiceImpl menuServiceImpl;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String is_freeship,
            @RequestParam String time_ship,
            @RequestParam double price,
            @RequestParam int cate_id){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = menuServiceImpl.createMenu(file, title, is_freeship, time_ship, price, cate_id);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
