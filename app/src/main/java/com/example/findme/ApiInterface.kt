package com.example.findme

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiInterface {
    @Headers("X-RapidAPI-Key': '82501211f4msh3a099a43fabf783p1e6606jsnecc361a86c3f",
    "X-RapidAPI-Host': 'moviesdatabase.p.rapidapi.com")
    @GET("titles/search/")//making a GET request  with endpoint search
fun getData(
        @Query("title")query: String
    ) : Call<MyData>
}