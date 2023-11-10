package com.example.findme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            //.baseUrl("https://moviesdatabase.p.rapidapi.com/")
            .baseUrl("https://moviesdatabase.p.rapidapi.com/titles/search/title/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        //https://moviesdatabase.p.rapidapi.com/titles/search/title/tmnt?exact=false&titleType=movie
        val retrofitData = retrofitBuilder.getData(
            //"title/avengers?exact=false&titleType=movie"
        "tmnt?exact=false&titleType=movie"
        )

        retrofitData.enqueue(object: Callback<MyData?>{
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful) {
                    
                    val dataList = response.body()?.results

                    if (dataList != null) {
                        myAdapter = MyAdapter(this@MainActivity, dataList)
                        myRecyclerView.adapter = myAdapter
                        myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        Log.d("Tag: onResponse", "onResponse ${response.body()}")
                    } else {
                        Log.d("Tag: onResponse", "Data list is null")
                    }
                } else {
                    Log.d("Tag: onResponse", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Tag: onFailure","onFailure ${t.message}")
            }
        })
    }
}