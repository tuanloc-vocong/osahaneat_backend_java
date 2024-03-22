package com.tuanloc.osahaneat.dto;

import java.util.List;

public class CategoryDto {
    private String name;
    private List<MenuDto> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuDto> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDto> menus) {
        this.menus = menus;
    }
}
