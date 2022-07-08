package com.nitin.tmdbmoviesclient.data.model.artist


import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("results")
    val results: List<People>,
)