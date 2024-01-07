package kh.edu.rupp.ite.daytoon.controller.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityStoryshowBinding
import kh.edu.rupp.ite.daytoon.model.StoryNovel
import kh.edu.rupp.ite.daytoon.model.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class StoryShowActivity: AppCompatActivity() {

    private lateinit var binding: ActivityStoryshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryshowBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
        loadStoryFromServer()
    }
    private fun loadStoryFromServer() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val task: Call<List<StoryNovel?>?>? = apiService.loadMoviesList()
        task?.enqueue(object : Callback<List<StoryNovel?>?> {
            override fun onFailure(call: Call<List<StoryNovel?>?>, t: Throwable) {
//                Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                Log.e("[AnimeFragment]", "load failed" + t.message)
            }

            override fun onResponse(
                call: Call<List<StoryNovel?>?>,
                response: Response<List<StoryNovel?>?>
            ) {

                if (response.isSuccessful) {
                    val storyNovel: List<StoryNovel?>? = response.body()

                    if (storyNovel != null) {
//                        showStoryNovelUpdate(storyNovel)
//                        Toast.makeText(context, "Anime Show", Toast.LENGTH_SHORT).show()

                    } else {
//                        Toast.makeText(context, "Anime list is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Handle unsuccessful response
//                    Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}