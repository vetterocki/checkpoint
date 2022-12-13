package com.example.checkpoint.model.menus;

import java.util.ArrayList;
import java.util.List;

public class SecurityCheckPointMenu extends CheckPointMenu {

    public SecurityCheckPointMenu() {
        super();
    }

    @Override
    public String[] configureLines() {
        List<String> lines = new ArrayList<>();
        lines.add("1. Check all the people entered the building.");
        lines.add("2. Check the last person entered the building.");
        lines.add("3. Exit the menu.");
        return lines.toArray(String[]::new);
    }
}
