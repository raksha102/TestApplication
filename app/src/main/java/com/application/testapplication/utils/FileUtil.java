package com.application.testapplication.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

public class FileUtil {

    @Inject
    public FileUtil() {
    }

    public String readFromFle(InputStream inputStream){
        String data = null;

        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            data = new String(buffer, "UTF-8");
        }catch (IOException io){
            io.printStackTrace();
        }

        return data;
    }
}
