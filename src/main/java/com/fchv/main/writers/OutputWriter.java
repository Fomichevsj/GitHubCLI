package com.fchv.main.writers;


public interface OutputWriter {

    /**
     * write result to either sdtOut or to file
     * @param data data in table style to be written
     * @param columns header of the table
     */
    public void writeTable(String[] columns, String[][] data);
}
