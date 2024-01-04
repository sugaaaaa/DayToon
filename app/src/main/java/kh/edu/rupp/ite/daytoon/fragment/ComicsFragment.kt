package kh.edu.rupp.ite.daytoon.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kh.edu.rupp.ite.daytoon.api.model.Anime
import kh.edu.rupp.ite.daytoon.api.model.AnimeList
import kh.edu.rupp.ite.daytoon.api.service.ApiService
import kh.edu.rupp.ite.daytoon.databinding.FragmentComicsBinding
import kh.edu.rupp.ite.onlineshop.api.adapter.AnimePreviewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicsFragment :  Fragment(){

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
        // Your code for fragment initialization and UI interactions goes here
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
                        // Successfully retrieved anime list, now you can do something with it
                        // Example: Log the first anime's title
                        showAnimeList(animeList.getData())
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
    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding when the view is destroyed
        _binding = null
    }


}