package com.fchv.main.writers;


public class WriterProvider {

    public static OutputWriter getWriterFor(String pathToFile) {
        if (pathToFile != null && pathToFile.length() > 0) {
            return new ToFileWriter(pathToFile);
        } else {
            return new StdOutputWriter();
        }
    }
}
