package kh.edu.rupp.ite.daytoon.controller.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kh.edu.rupp.ite.daytoon.model.Anime
import kh.edu.rupp.ite.daytoon.model.AnimeList
import kh.edu.rupp.ite.daytoon.model.service.ApiService
import kh.edu.rupp.ite.daytoon.databinding.FragmentStoryBinding
import kh.edu.rupp.ite.daytoon.controller.adabter.AnimePreviewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoryFragment : Fragment() {
    private lateinit var binding: FragmentStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnimeFromServer()
    }

    private fun loadAnimeFromServer() {
        Log.d("[AnimeFragment]", "Attempting to load anime from the server.")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://anime-db.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val task: Call<AnimeList>? = apiService.getAnimeList()
        task?.enqueue(object : Callback<AnimeList> {
            override fun onResponse(call: Call<AnimeList>, response: Response<AnimeList>) {
                if (response.isSuccessful) {
                    Log.d("[AnimeFragment]", "API call successful.")
                    val animeList: AnimeList? = response.body()

                    if (animeList != null) {
                        showAnimeList(animeList.getData())
                    } else {
                        Log.w("[AnimeFragment]", "Anime list is null.")
                        Toast.makeText(context, "Anime list is null", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("[AnimeFragment]", "Unsuccessful response. Code: ${response.code()}")
                    Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AnimeList>, t: Throwable) {
                Log.e("[AnimeFragment]", "API call failed. Error: ${t.message}")
                Toast.makeText(context, "Anime load went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showAnimeList(animeList: List<Anime>?) {
        if (animeList.isNullOrEmpty()) {
            // Handle empty data case
            Toast.makeText(context, "Anime list is empty", Toast.LENGTH_SHORT).show()
        } else {
            val linearLayoutManager = GridLayoutManager(context, 2)
            binding.productRecyclerView.layoutManager = linearLayoutManager

            val adapter = AnimePreviewAdapter()
            adapter.submitList(animeList)
            binding.productRecyclerView.adapter = adapter
        }
    }



}

