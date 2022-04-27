package com.fchv.main.writers;

import dnl.utils.text.table.TextTable;

public class StdOutputWriter implements OutputWriter {

    @Override
    public void writeTable(String[] columns, String[][] data) {
        TextTable tt = new TextTable(columns, data);
        tt.printTable();
    }

}
