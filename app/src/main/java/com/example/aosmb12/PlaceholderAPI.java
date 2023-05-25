package com.example.aosmb12;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceholderAPI {
    @GET("comments")
    Call<List<Comment>> getAllComments();

    @POST("comments")
    Call<Comment> createComment(@Body Comment comment);

    @GET("comments")
    Call<List<Comment>> getCommentsByUser(@Query("userId") int userId);

    @GET("comments/{id}")
    Call<Comment> getCommentById(@Path("id") int id);
}
