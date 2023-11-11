package kh.edu.rupp.ite.daytoon.page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypeBinding

class TypeStoryActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTypeBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}