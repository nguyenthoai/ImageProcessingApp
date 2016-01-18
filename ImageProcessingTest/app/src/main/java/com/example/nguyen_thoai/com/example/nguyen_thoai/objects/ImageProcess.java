package com.example.nguyen_thoai.com.example.nguyen_thoai.objects;

/**
 * Created by Nguyen_Thoai on 1/18/2016.
 */
public class ImageProcess {

    public ImageProcess() {

    }

    public ImageProcess(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    private String pathImage;
}
