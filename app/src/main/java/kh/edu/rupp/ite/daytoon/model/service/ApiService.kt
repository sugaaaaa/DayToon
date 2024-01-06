package kh.edu.rupp.ite.daytoon.model.service
import kh.edu.rupp.ite.daytoon.model.AnimeList
import kh.edu.rupp.ite.daytoon.model.StoryNovel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiService {

//    @Headers(
//        "X-Rapidapi-Key: 2dcef4408cmsh89dee1c42827b64p15153cjsn28517f898be3",
//        "X-Rapidapi-Host: anime-manga-and-novels-api.p.rapidapi.com"
//    )
//    @GET("anime/{id}")
//    fun getAnime(@Path("id") animeId: Int): Call<LibraryFragment?>?

    @GET("/MRatana/movieapi/main/movies.json")
    fun loadMoviesList(): Call<List<StoryNovel?>?>?
    @Headers(
        "X-RapidAPI-Key: 2dcef4408cmsh89dee1c42827b64p15153cjsn28517f898be3",
        "X-RapidAPI-Host: anime-db.p.rapidapi.com"
    )
    @GET("anime?page=1&size=10&search=Fullmetal&genres=Fantasy%2CDrama&sortBy=ranking&sortOrder=asc")
    fun getAnimeList(): Call<AnimeList>?
//    abstract fun getAnimeList(): Call<List<Anime>?>?
}

