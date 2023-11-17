package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingupBinding

class SingUpActivity: AppCompatActivity() {
  private lateinit var binding: ActivitySingupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.textlogin.setOnClickListener {
            var intent = Intent(this@SingUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}