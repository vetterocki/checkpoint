package com.example.checkpoint.service.security;

import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.menus.CheckPointMenu;
import com.example.checkpoint.model.menus.HRCheckPointMenu;
import com.example.checkpoint.model.menus.SecurityCheckPointMenu;
import com.example.checkpoint.model.menus.WorkerCheckPointMenu;
import org.springframework.stereotype.Component;

@Component
public class CheckPointMenuAuthorizationManager implements AuthorizationManager<Role, CheckPointMenu> {

    @Override
    public CheckPointMenu authorize(Role source) {
        return switch (source) {
            case WORKER -> new WorkerCheckPointMenu();
            case SECURITY -> new SecurityCheckPointMenu();
            case HR -> new HRCheckPointMenu();
        };
    }
}
