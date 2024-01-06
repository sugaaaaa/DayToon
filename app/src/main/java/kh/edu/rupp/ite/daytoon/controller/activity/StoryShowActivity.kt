package kh.edu.rupp.ite.daytoon.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityStoryshowBinding

class StoryShowActivity: AppCompatActivity() {
    private lateinit var binding: ActivityStoryshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryshowBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}