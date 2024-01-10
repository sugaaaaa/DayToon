package kh.edu.rupp.ite.daytoon.model

import com.google.gson.annotations.SerializedName

class AnimeList {
    @SerializedName("data")
    private var data : List<Anime>? = null

    fun getData(): List<Anime>? {
        return data
    }

    fun setData(data : List<Anime>?) {
        this.data = data
    }
}