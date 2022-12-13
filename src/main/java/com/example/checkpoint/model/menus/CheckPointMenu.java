package com.example.checkpoint.model.menus;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public abstract class CheckPointMenu {
    protected List<String> menuLines;

    protected CheckPointMenu() {
        this.menuLines = fillMenuLines(configureLines());
    }

    protected List<String> fillMenuLines(String... lines) {
        return Arrays.stream(lines).toList();
    }

    public abstract String[] configureLines();
}
