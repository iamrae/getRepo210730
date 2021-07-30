package com.example.getrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val baseUrl = "https://api.github.com/"
    val username = "iamrae"
    val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitApi = retrofitBuilder.create(GithubService::class.java)
        val getUserData = retrofitApi.getUserDataCall(username)
        val getRepoData = retrofitApi.getUserReposCall(username)

        getRepoData.enqueue(object : Callback<List<RepoData>> {

            override fun onResponse(
                call: Call<List<RepoData>>,
                response: Response<List<RepoData>>
            ) {
                Log.e(TAG, "onResponse: $response")
            }

            override fun onFailure(call: Call<List<RepoData>>, t: Throwable) {
                Log.e(TAG, "onFailure: $t")
            }
        })

        getUserData.enqueue(object : Callback<List<UserData>> {

            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                Log.e(TAG, "onResponse: $response" )
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                Log.e(TAG, "onFailure: $t")
            }
        })
    }


}