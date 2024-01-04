package kh.edu.rupp.ite.daytoon.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import kh.edu.rupp.ite.daytoon.R

import kh.edu.rupp.ite.daytoon.databinding.ActicityWelcomeBinding

class WelcomePageActivity: AppCompatActivity(){

    private lateinit var binding: ActicityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActicityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomButton: Button = findViewById(R.id.next)

        bottomButton.setOnClickListener {

            val intent = Intent(this, Welcome2Activity::class.java)

            startActivity(intent)
        }
    }
}