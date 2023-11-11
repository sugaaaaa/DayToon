package kh.edu.rupp.ite.daytoon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}