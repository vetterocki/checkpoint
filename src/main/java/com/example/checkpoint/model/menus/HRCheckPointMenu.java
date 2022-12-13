package com.example.checkpoint.model.menus;

import java.util.ArrayList;
import java.util.List;

public class HRCheckPointMenu extends CheckPointMenu {

    public HRCheckPointMenu() {
        super();
    }

    @Override
    public String[] configureLines() {
        List<String> lines = new ArrayList<>();
        lines.add("1. Check total report about workers.");
        lines.add("2. Exit the menu.");
        return lines.toArray(String[]::new);
    }
}
