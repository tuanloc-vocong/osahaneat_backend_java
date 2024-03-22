package com.tuanloc.osahaneat.service;

import com.tuanloc.osahaneat.entity.Category;
import com.tuanloc.osahaneat.entity.Food;
import com.tuanloc.osahaneat.repository.FoodRepository;
import com.tuanloc.osahaneat.service.impl.FileServiceImpl;
import com.tuanloc.osahaneat.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MenuService implements MenuServiceImpl {
    @Autowired
    FileServiceImpl fileServiceImpl;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean createMenu(MultipartFile file, String title, String is_freeship, String time_ship, double price, int cate_id) {
        boolean isInsertSuccess = false;
        try{
            boolean isSaveSuccess = fileServiceImpl.saveFile(file);
            if(isSaveSuccess){
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_ship);
                food.setPrice(price);

                Category category = new Category();
                category.setId(cate_id);
                food.setCategory(category);
                foodRepository.save(food);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
