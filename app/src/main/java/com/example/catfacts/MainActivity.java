package com.example.catfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    String api = "https://catfact.ninja";
    TextView tv;
    Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        tv = findViewById(R.id.tv);
        load = findViewById(R.id.load);
//        tv.append("Isar Nigar Ahmad");

    loadFact();
    load.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loadFact();
        }
    });

    }



    public void loadFact(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi api1 = retrofit.create((myApi.class));


        Call<Model> call=  api1.getData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){
                    tv.setText(response.body().getFact());
                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

}