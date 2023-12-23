package kh.edu.rupp.ite.daytoon.page

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
            val intent = Intent(this, TypeStoryActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}