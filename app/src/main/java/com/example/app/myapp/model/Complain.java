package com.example.app.myapp.model;

import android.net.Uri;

public class Complain {
    private String phone,message,thana_id,fari_id,crime_id,video,audio;
    private String img;

    public Complain() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThana_id() {
        return thana_id;
    }

    public void setThana_id(String thana_id) {
        this.thana_id = thana_id;
    }

    public String getFari_id() {
        return fari_id;
    }

    public void setFari_id(String fari_id) {
        this.fari_id = fari_id;
    }

    public String getCrime_id() {
        return crime_id;
    }

    public void setCrime_id(String crime_id) {
        this.crime_id = crime_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
