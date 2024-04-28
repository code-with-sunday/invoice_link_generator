package com.sunday.invoice_link_generator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CompanyIOUtils {
    private static final Logger logger = LoggerFactory.getLogger(CompanyIOUtils.class);

    public void createFileFromByteArray(byte[] data, String fileLocation,String subDirectory,String fileName, String fileExtension)
            throws Exception {
        StringBuilder fileDirectory = new StringBuilder(fileLocation).append(subDirectory);
        File directory = new File(fileDirectory.toString());

        if (!directory.exists()) {
            directory.mkdirs();
        }

        StringBuilder fileNameWithExtension = new StringBuilder(fileName).append(fileExtension);

        File file = new File(directory, fileNameWithExtension.toString());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(data);
        } catch (FileNotFoundException e) {
            logger.error("Error: {}, Cause: {}", e.getMessage(), e.getCause());
            throw new Exception("Couldn't create a file!");
        } catch (IOException e) {
            logger.error("Error: {}, Cause:", e.getMessage(), e.getCause());
            throw new Exception("Couldn't write on created file!");
        } finally {
            if (fos != null)
                fos.close();
        }
    }
}
