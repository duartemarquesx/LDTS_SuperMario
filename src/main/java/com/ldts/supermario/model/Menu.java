package com.ldts.supermario.model;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("START","HELP", "ABOUT", "EXIT");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public int getCurrentEntry(){
        return currentEntry;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedExit() {
        return isSelected(3);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedHelp() {
        return isSelected(1);
    }
    public boolean isSelectedAbout() {
        return isSelected(2);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}