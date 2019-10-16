package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overview;
    String backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = "https://image.tmdb.org/t/p/w300/" + jsonObject.get("backdrop_path");
        posterPath = "https://image.tmdb.org/t/p/w154/" + jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movie = new ArrayList<>();
        for( int i = 0; i <movieJsonArray.length(); i++){
            movie.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movie;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
