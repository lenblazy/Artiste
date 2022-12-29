package com.lenibonje.artistes.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val TVShows: List<TVShow>,
)