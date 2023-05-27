package com.example.aosmb12.UI.viewmodels;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.aosmb12.UI.RetrofitFactory;
import com.example.aosmb12.data.dataSource.APIs.PlaceholderAPI;
import com.example.aosmb12.data.dataSource.Comments;
import com.example.aosmb12.data.repositors.Repository;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private Repository commentRepository;
    private MutableLiveData<Comments> commentLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Comments>> commentsLiveData = new MutableLiveData<>();

    public ViewModel() {
        commentRepository = new Repository();
    }

    public LiveData<Comments> getUser() {
        return commentLiveData;
    }

    public LiveData<List<Comments>> getUsers() {
        return commentsLiveData;
    }

    public void apiDataTransf() {
       commentRepository.apiDataTransf();
    }
}