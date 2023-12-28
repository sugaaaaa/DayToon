package kh.edu.rupp.ite.daytoon.page

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.LoginActivity
import kh.edu.rupp.ite.daytoon.databinding.ActicityWelcome2Binding

class Welcome2Activity : AppCompatActivity() {

    private lateinit var binding: ActicityWelcome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActicityWelcome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            // Launch the SelectGenresActivity to allow the user to select genres
            val intent = Intent(this, TypeStoryActivity::class.java)
            startActivity(intent)
        }
    }
}