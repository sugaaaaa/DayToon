package kh.edu.rupp.ite.daytoon.api.service

import kh.edu.rupp.ite.daytoon.fragment.LibraryFragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: 2dcef4408cmsh89dee1c42827b64p15153cjsn28517f898be3",
        "X-RapidAPI-Host: anime-manga-and-novels-api.p.rapidapi.com"
    )
    @GET("manga/{id}")
    fun getManga(@Path("id") mangaId: Int): Call<LibraryFragment?>?
}