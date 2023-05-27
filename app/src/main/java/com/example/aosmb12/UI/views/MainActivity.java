package com.example.aosmb12.UI.views;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import android.os.Bundle;
import android.util.Log;
import com.example.aosmb12.R;
import com.example.aosmb12.UI.viewmodels.ViewModel;
import com.example.aosmb12.data.dataSource.Comments;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;

    public final String URL_API = "https://jsonplaceholder.typicode.com/";

    public String TAG = "getDataFromApi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModel();

        viewModel.getUser().observe(this, new Observer<com.example.aosmb12.data.dataSource.Comments>() {
            @Override
            public void onChanged(com.example.aosmb12.data.dataSource.Comments user) {
                Log.d(TAG, "User name: " + user.getName());
            }
        });

        viewModel.getUsers().observe(this, new Observer<List<com.example.aosmb12.data.dataSource.Comments>>() {
            @Override
            public void onChanged(List<Comments> users) {
                Log.d(TAG, "User list:" + users.toString());
            }
        });

        viewModel.apiDataTransf();
    }
}