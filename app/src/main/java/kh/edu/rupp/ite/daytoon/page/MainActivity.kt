package kh.edu.rupp.ite.daytoon.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}