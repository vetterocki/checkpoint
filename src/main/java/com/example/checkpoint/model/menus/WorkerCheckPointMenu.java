package com.example.checkpoint.model.menus;

import java.util.ArrayList;
import java.util.List;

public class WorkerCheckPointMenu extends CheckPointMenu {

    public WorkerCheckPointMenu() {
        super();
    }

    @Override
    public String[] configureLines() {
        List<String> lines = new ArrayList<>();
        lines.add("1. Go into the company building.");
        lines.add("2. Get out of the company building.");
        lines.add("3. Exit the menu.");
        return lines.toArray(String[]::new);
    }
}
