package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.moviefinder.databinding.ActivityMainBinding;
import com.example.moviefinder.model.ResponseMovie;
import com.example.moviefinder.remote.APIService;
import com.example.moviefinder.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        String API_KEY = "1f63b279";

        APIService apiService= RetrofitClient.getClient().create(APIService.class);


        binding.btnFind.setOnClickListener(v -> {

            Toast.makeText(this,"this is a test",Toast.LENGTH_SHORT).show();
            String name = binding.etName.getText().toString();

            Call<ResponseMovie> callResponseMovie = apiService.getMovieList(name,API_KEY);

            callResponseMovie.enqueue(new Callback<ResponseMovie>() {
                @Override
                public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                    Log.i("mainActivity", "onResponse: " + response.body());

                    binding.tvTitle.setText(response.body().getTitle());
                    binding.tvGenre.setText(response.body().getGenre());
                    binding.tvYear.setText(response.body().getYear());

                }

                @Override
                public void onFailure(Call<ResponseMovie> call, Throwable t) {
                    Log.i("mainActivity", "onFail: " + t.toString());

                }
            });

        });

    }
}
