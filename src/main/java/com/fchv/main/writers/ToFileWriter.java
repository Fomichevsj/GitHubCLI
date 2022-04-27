package com.fchv.main.writers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import dnl.utils.text.table.TextTable;

public class ToFileWriter implements OutputWriter {

    private final String pathToFile;

    public ToFileWriter(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void writeTable(String[] columns, String[][] data) {
        try (PrintStream fps = new PrintStream(new FileOutputStream(pathToFile))) {
            TextTable tt = new TextTable(columns, data);
            tt.printTable(fps, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
