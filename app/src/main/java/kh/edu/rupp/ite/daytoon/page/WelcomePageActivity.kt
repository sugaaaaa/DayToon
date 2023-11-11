package kh.edu.rupp.ite.daytoon.page

import android.app.AppComponentFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActicityWelcomeBinding

class WelcomePageActivity: AppCompatActivity(){

    private lateinit var binding: ActicityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActicityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}