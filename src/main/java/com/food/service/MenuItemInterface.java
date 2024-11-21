package com.food.service;

import java.util.List;

import com.food.dto.MenuItemDto;
import com.food.entity.MenuItem;

public interface MenuItemInterface {

    public MenuItem createMenuItem(MenuItemDto menuItemDto);

    public List<MenuItem> getMenuList(long id);

    public MenuItem updateMenuItem(MenuItemDto menuItemDto, long id);

    public String deleteById(long id);

    public List<MenuItem> findMenuItemsByName(String name);
}
