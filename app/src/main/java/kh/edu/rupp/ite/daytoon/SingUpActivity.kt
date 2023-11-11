package kh.edu.rupp.ite.daytoon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingupBinding

class SingUpActivity: AppCompatActivity() {
  private lateinit var binding: ActivitySingupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root);
    }
}