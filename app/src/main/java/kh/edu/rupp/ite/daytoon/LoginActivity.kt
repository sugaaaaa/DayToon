package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityLoginBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity

class LoginActivity: AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val btnsignupButton: Button = findViewById(R.id.btnsinup)
        val btnloginButton: Button = findViewById(R.id.btnlogin)

        btnsignupButton.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }

        btnloginButton.setOnClickListener {
            val intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)
        }
    }
}