package kh.edu.rupp.ite.daytoon.page

import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.LoginActivity
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
            val intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)
        }
    }


}