package com.example.aosmb12;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public final String URL_API = "https://jsonplaceholder.typicode.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiDataTransf();
    }
    private void apiDataTransf(){
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI serviceAPI = retrofit.create(PlaceholderAPI.class);
        int Id = 20;
        int postId = 3;
        Call<Comments> call1 = serviceAPI.getCommentById(Id);
        call1.enqueue(new Callback<Comments>() {
            @Override
            public void onResponse(Call<Comments> call, Response<Comments> response) {
                if (response.isSuccessful()) {
                    Comments comments = response.body();
                    Log.d("Успех!", "Данные:" + comments.getName());

                } else {
                    Log.e("Не успех", "Не вышло(");
                }
            }
            @Override
            public void onFailure(Call<Comments> call, Throwable t) {
                Log.e("Не получилось", "Ошибка:" + t.getMessage());
            }
        });
        Call<List<Comments>> call2 = serviceAPI.getCommentsByPostId(postId);
        call2.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (response.isSuccessful()) {
                    List<Comments> comments = response.body();

                    for (int i = 0;i<comments.size();i++){
                        Log.d("Успех!", "Данные:" + comments.get(i).getName());
                    }
                } else {
                    Log.e("Не успех", "Не вышло(");
                }
            }
            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Log.e("Не получилось", "Ошибка:" + t.getMessage());
            }
        });
        Comments comment = new Comments(2, "Nikita@garfield.biz");
        Call<Comments> call3 = serviceAPI.createComment(comment);
        call3.enqueue(new Callback<Comments>() {
            @Override
            public void onResponse(Call<Comments> call, Response<Comments> response) {
                if (response.isSuccessful()) {
                    Comments comments = response.body();
                        Log.d("Успех!", "Данные:" + comments.getEmail());

                } else {
                    Log.e("Не успех", "Не вышло(");
                }
            }
            @Override
            public void onFailure(Call<Comments> call, Throwable t) {
                Log.e("Не получилось", "Ошибка:" + t.getMessage());
            }
        });
    }
}