package com.example.moviefinder.model;

import com.google.gson.annotations.SerializedName;

public class ResponseMovie {

    @SerializedName("Title")
    String title;
    @SerializedName("Year")
    String year;
    @SerializedName("Genre")
    String genre;
    @SerializedName("Director")
    String director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
