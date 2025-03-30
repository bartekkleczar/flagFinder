package com.example.flagfinder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApiService {
    @GET("countries/filter")
    suspend fun filterCountries(
        @Query("red") red: Int,
        @Query("green") green: Int,
        @Query("blue") blue: Int,
        @Query("yellow") yellow: Int,
        @Query("orange") orange: Int,
        @Query("white") white: Int,
        @Query("black") black: Int,
        @Query("horizontal") horizontal: Int,
        @Query("vertical") vertical: Int,
        @Query("diagonal") diagonal: Int,
        @Query("centered") centered: Int,
        @Query("triangleHorizontal") triangleHorizontal: Int,
        @Query("other") other: Int,
        @Query("circle_sign") circleSign: Int,
        @Query("crescent_sign") crescentSign: Int,
        @Query("cross_sign") crossSign: Int,
        @Query("star_sign") starSign: Int,
        @Query("sun_sign") sunSign: Int,
        @Query("other_sign") otherSign: Int,
        @Query("nosigns") noSigns: Int
    ): List<CountryDTO>
}

object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    val api: CountryApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApiService::class.java)
    }
}