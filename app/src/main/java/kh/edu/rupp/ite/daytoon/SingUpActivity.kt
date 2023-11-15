package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingupBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity

class SingUpActivity: AppCompatActivity() {
  private lateinit var binding: ActivitySingupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val btnsignupButton: Button = findViewById(R.id.btnsinup)

        btnsignupButton.setOnClickListener {
            val intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)
        }
        val textView: TextView = findViewById(R.id.logintxt)

        btnsignupButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}