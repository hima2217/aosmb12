package com.example.aosmb12.data.dataSource.APIs;

import com.example.aosmb12.data.dataSource.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceholderAPI {
    @GET("comments")
    Call<List<Comments>> getAllComments();

    @POST("comments")
    Call<Comments> createComment(@Body Comments comment);

    @GET("comments")
    Call<List<Comments>> getCommentsByPostId(@Query("postId") int postId);

    @GET("comments/{id}")
    Call<Comments> getCommentById(@Path("id") int id);
}
