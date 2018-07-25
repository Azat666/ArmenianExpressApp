package com.example.student.arminianexpresapp.models;

public class ProduktModel {
    private String title;
    private int[] imageId;
    private int description;
    private String videoUrl;
    public boolean isliked = false;
    public boolean isToBasket = false;
    private float rating;
    private String type;

    public ProduktModel(String title, int[] imageId, int description, String videoUrl, float reting, String type) {
        this.title = title;
        this.imageId = imageId;
        this.description = description;
        this.videoUrl = videoUrl;
        this.rating = reting;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getImageId() {
        return imageId;
    }

    public void setImageId(int[] imageId) {
        this.imageId = imageId;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public float getReting() {
        return rating;
    }

    public void setReting(float reting) {
        this.rating = reting;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
