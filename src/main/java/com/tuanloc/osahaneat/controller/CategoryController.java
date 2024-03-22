package com.tuanloc.osahaneat.controller;

import com.tuanloc.osahaneat.payload.ResponseData;
import com.tuanloc.osahaneat.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @GetMapping()
    public ResponseEntity<?> getHomeCategory(){
        ResponseData responseData = new ResponseData();
        responseData.setData(categoryServiceImpl.getCategoryHomePage());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
