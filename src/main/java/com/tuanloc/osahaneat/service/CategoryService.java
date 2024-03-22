package com.tuanloc.osahaneat.service;

import com.tuanloc.osahaneat.dto.CategoryDto;
import com.tuanloc.osahaneat.dto.MenuDto;
import com.tuanloc.osahaneat.entity.Category;
import com.tuanloc.osahaneat.entity.Food;
import com.tuanloc.osahaneat.repository.CategoryRepository;
import com.tuanloc.osahaneat.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImpl {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        List<CategoryDto> listCategoryDtos = new ArrayList<>();

        for (Category data : listCategory){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(data.getNameCate());

            List<MenuDto> menuDtos = new ArrayList<>();
            for (Food dataFood : data.getListFood()){
                MenuDto menuDto = new MenuDto();
                menuDto.setTitle(dataFood.getTitle());
                menuDto.setFreeship(dataFood.isFreeship());
                menuDto.setImage(dataFood.getImage());

                menuDtos.add(menuDto);
            }

            categoryDto.setMenus(menuDtos);
            listCategoryDtos.add(categoryDto);
        }
        return listCategoryDtos;
    }
}
