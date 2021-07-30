package com.example.getrepos

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{username}")
    fun getUserDataCall(@Path("username") userName : String) : Call<List<UserData>>

    @GET("/users/{username}/repos")
    fun getUserReposCall(@Path("username")userName: String) : Call<List<RepoData>>
}

