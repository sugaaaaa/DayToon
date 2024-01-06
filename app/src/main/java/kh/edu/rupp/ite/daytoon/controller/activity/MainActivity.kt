package kh.edu.rupp.ite.daytoon.controller.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kh.edu.rupp.ite.daytoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        Handler().postDelayed({
            val intent = Intent(this, WelcomePageActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}