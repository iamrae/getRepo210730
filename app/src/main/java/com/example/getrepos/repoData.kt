package com.example.getrepos

import com.google.gson.annotations.SerializedName

data class UserData (
    @SerializedName("login")
    var userName : String = "",
    @SerializedName("avatar_url")
    var userProfileUrl : String = ""
)

data class RepoData (
    @SerializedName("name")
    var repoName : String = "",
    @SerializedName("description")
    var repoDescription : String = "",
    @SerializedName("stargazers_count")
    var starCount : Int = 0
)