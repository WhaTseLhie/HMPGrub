package com.example.jayvee.hmpgrub;

public class Reviews {

    String review_image, review_name, review_written, review_rating;

    public Reviews(String review_name, String review_written, String review_rating) {
        this.review_name = review_name;
        this.review_written = review_written;
        this.review_rating = review_rating;
    }

    public Reviews(String review_image, String review_name, String review_written, String review_rating) {
        this.review_image = review_image;
        this.review_name = review_name;
        this.review_written = review_written;
        this.review_rating = review_rating;
    }

    public String getReview_image() {
        return review_image;
    }

    public void setReview_image(String review_image) {
        this.review_image = review_image;
    }

    public String getReview_name() {
        return review_name;
    }

    public void setReview_name(String review_name) {
        this.review_name = review_name;
    }

    public String getReview_written() {
        return review_written;
    }

    public void setReview_written(String review_written) {
        this.review_written = review_written;
    }

    public String getReview_rating() {
        return review_rating;
    }

    public void setReview_rating(String review_rating) {
        this.review_rating = review_rating;
    }
}
