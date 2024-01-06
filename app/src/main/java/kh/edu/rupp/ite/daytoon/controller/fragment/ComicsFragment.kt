package kh.edu.rupp.ite.daytoon.controller.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
        // Inflate the layout using View Binding
        _binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnimeFromServer()
        loadStoryFromServer()
        // Your code for fragment initialization and UI interactions goes here
        val adapter = StoryNovelAdapter(/* pass your data to the adapter */)
        adapter.setOnItemClickListener(this)

        binding.StoryRecyclerView.adapter = adapter
        // ... other setup for your RecyclerView if needed
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
                        // Example: Log the first anime's title
                        showAnimeList(animeList.getData())
                    } else {
                        // Handle the case where the response body is null
                        Toast.makeText(context, "Anime list is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Handle unsuccessful response
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
                // Handle failure
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
                        // Successfully retrieved anime list, now you can do something with it
                        // Example: Log the first anime's title
                        showStoryNovelUpdate(storyNovel)
//                        Toast.makeText(context, "Anime Show", Toast.LENGTH_SHORT).show()

                        // Uncomment the following line to show the anime list
                        // showAnimeList(animeList.getData())
                    } else {
                        // Handle the case where the response body is null
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
        // Clean up the binding when the view is destroyed
        _binding = null
    }

     override fun onItemClick(storyNovel: StoryNovel, position: Int) {
         val array = arrayOf(
             storyNovel.getId(),
             storyNovel.getTitle(),
             storyNovel.getDescription(),
             storyNovel.getImg(),
         )

//         val intent = Intent(requireContext(), StoryShowActivity::class.java)
//         intent.putExtra("movie", array)
//         startActivity(intent)
         Toast.makeText(context, storyNovel.getTitle(), Toast.LENGTH_SHORT).show()
     }
}