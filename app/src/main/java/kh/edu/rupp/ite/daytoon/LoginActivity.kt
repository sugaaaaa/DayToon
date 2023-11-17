package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityLoginBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity

class LoginActivity: AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.btnlogin.setOnClickListener{
            var intent= Intent(this@LoginActivity, IndexActivity::class.java )
            startActivity(intent)
        }
        binding.btnsinup.setOnClickListener {
            var intent= Intent(this@LoginActivity, SingUpActivity::class.java)
            startActivity(intent)
        }
    }
}