package com.example.dummy;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class Model
{
    private String header;
    private String desc;
    //private String info;
    //private String link;
    private int imgname;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public int getImgname() {
        return imgname;
    }

    public void setImgname(int imgname) {
        this.imgname = imgname;
    }



}
