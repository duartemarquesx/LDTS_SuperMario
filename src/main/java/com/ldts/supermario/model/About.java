package com.ldts.supermario.model;

import java.util.Arrays;
import java.util.List;

public class About {
    private final List<String> entries;
    private int currentEntry = 0;
    public About() {
        this.entries = Arrays.asList("RETURN TO MENU");
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
    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedMenu() {
        return isSelected(0);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}