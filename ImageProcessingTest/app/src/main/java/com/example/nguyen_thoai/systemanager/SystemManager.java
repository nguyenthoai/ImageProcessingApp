package com.example.nguyen_thoai.systemanager;

import android.util.Log;

import com.example.nguyen_thoai.com.example.nguyen_thoai.objects.ImageProcess;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Nguyen_Thoai on 1/18/2016.
 */
public class SystemManager {
    public static final String HOME_PATH = "/";

    public SystemManager() {
        this.listImageProcess = new ArrayList<>();
        this.homeFile = new File(HOME_PATH);
    }

    public void getListImage(File home) {
        File[] files = home.listFiles();
        if (files == null) {
            return;
        }
//        Log.e("getPath----------", home.getPath());
        for (File file : files) {
            if (!file.isDirectory() && (file.getName().toLowerCase().endsWith(".jpg") ||
                    file.getName().toLowerCase().endsWith(".png"))) {
                String name = file.getName();
                String path = file.getPath();
                Log.e("systemanager", "path--->" + path);
                ImageProcess imageProcess = new ImageProcess(path);
                listImageProcess.add(imageProcess);
            } else {
                getListImage(file);
            }
        }
    }


    public ArrayList<ImageProcess> getListImageProcess() {
        return listImageProcess;
    }

    public void setListImageProcess(ArrayList<ImageProcess> listImageProcess) {
        this.listImageProcess = listImageProcess;
    }

    private ArrayList<ImageProcess> listImageProcess;
    private File homeFile;
}
