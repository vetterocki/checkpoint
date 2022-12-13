package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.User;
import com.example.checkpoint.model.menus.CheckPointMenu;
import com.example.checkpoint.model.menus.HRCheckPointMenu;
import com.example.checkpoint.model.menus.SecurityCheckPointMenu;
import com.example.checkpoint.model.menus.WorkerCheckPointMenu;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Configuration
public class MenuLinesConfigurer implements MenuConfigurer {
    ApplicationContext applicationContext;


    @Override
    public CommandsExecutor configureMenu(CheckPointMenu checkPointMenu, User user) {
        if (checkPointMenu instanceof WorkerCheckPointMenu)
            return applicationContext.getBean(WorkerCommandsExecutor.class);
        else if (checkPointMenu instanceof SecurityCheckPointMenu)
            return applicationContext.getBean(SecurityCommandsExecutor.class);
        else
            return applicationContext.getBean(HRCommandsExecutor.class);

    }

}
