package kh.edu.rupp.ite.daytoon.model

import com.google.gson.annotations.SerializedName

class Anime {
    @SerializedName("_id")
    private var _id: String? = null
    @SerializedName("title")
    private var title: String? = null
    @SerializedName("synopsis")
    private var synopsis: String? = null
    @SerializedName("image")
    internal var image: String? = null

    fun getId(): String? {
        return _id
    }

    fun setId(_id: String) {
        this._id = _id
    }

    fun getTitle(): String? {
        return title
    }


    fun setTitle(title: String?) {
        this.title = title
    }
    fun getSynopsis(): String? {
        return synopsis
    }

    fun setSynopsis(synopsis: String?) {
        this.synopsis = synopsis
    }

    fun getImage(): String? {
        return image
    }

    fun setImage(image: String?) {
        this.image = image
    }

}