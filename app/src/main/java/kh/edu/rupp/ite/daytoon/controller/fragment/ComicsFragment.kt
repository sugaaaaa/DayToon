package kh.edu.rupp.ite.daytoon.controller.fragment
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kh.edu.rupp.ite.daytoon.controller.activity.StoryShowActivity
import kh.edu.rupp.ite.daytoon.model.Anime
import kh.edu.rupp.ite.daytoon.model.AnimeList
import kh.edu.rupp.ite.daytoon.model.service.ApiService
import kh.edu.rupp.ite.daytoon.databinding.FragmentComicsBinding
import kh.edu.rupp.ite.daytoon.controller.adabter.AnimePreviewAdapter
import kh.edu.rupp.ite.daytoon.controller.adabter.StoryNovelAdapter
import kh.edu.rupp.ite.daytoon.model.StoryNovel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class ComicsFragment :  Fragment(), StoryNovelAdapter.OnItemClickListener{

    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnimeFromServer()
        loadStoryFromServer()
        val adapter = StoryNovelAdapter()
        adapter.setOnItemClickListener(this)

        binding.StoryRecyclerView.adapter = adapter
    }

    private fun loadAnimeFromServer() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://anime-db.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val task: Call<AnimeList>? = apiService.getAnimeList()
        task?.enqueue(object : Callback<AnimeList> {
            override fun onResponse(call: Call<AnimeList>, response: Response<AnimeList>) {
                if (response.isSuccessful) {
                    val animeList: AnimeList? = response.body()

                    if (animeList != null) {
                        showAnimeList(animeList.getData())
                    } else {
                        Toast.makeText(context, "Anime list is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AnimeList>, t: Throwable) {
                // Handle failure
                Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                Log.e("[AnimeFragment]", "load failed" + t.message)
            }
        })
    }
    private fun showAnimeList(animeList: List<Anime>?) {
        // layout manager
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.productRecyclerView.layoutManager = linearLayoutManager

        val adapter = AnimePreviewAdapter()
        adapter.submitList(animeList)
        binding.productRecyclerView.adapter = adapter
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
                Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                Log.e("[AnimeFragment]", "load failed" + t.message)
            }
            override fun onResponse(
                call: Call<List<StoryNovel?>?>,
                response: Response<List<StoryNovel?>?>
            ) {

                if (response.isSuccessful) {
                    val storyNovel: List<StoryNovel?>? = response.body()

                    if (storyNovel != null) {
                        showStoryNovelUpdate(storyNovel)
//                        Toast.makeText(context, "Anime Show", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Anime list is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    private fun showStoryNovelUpdate(animeList: List<StoryNovel?>?) {
        // layout manager
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.StoryRecyclerView.layoutManager = linearLayoutManager

        val adapter = StoryNovelAdapter()
        adapter.submitList(animeList)
        adapter.setOnItemClickListener(this)
        binding.StoryRecyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
     override fun onItemClick(storyNovel: StoryNovel, position: Int) {
         val array = arrayOf(
             storyNovel.getId(),
             storyNovel.getTitle(),
             storyNovel.getDescription(),
             storyNovel.getImg(),
         )
         val intent = Intent(requireContext(), StoryShowActivity::class.java)
         intent.putExtra("story", array)
         startActivity(intent)
//         Toast.makeText(context, storyNovel.getTitle(), Toast.LENGTH_SHORT).show()
     }
}