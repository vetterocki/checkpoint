package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.User;
import com.example.checkpoint.model.menus.CheckPointMenu;
import org.springframework.stereotype.Component;


public interface MenuConfigurer {
    CommandsExecutor configureMenu(CheckPointMenu checkPointMenu, User user);
}
