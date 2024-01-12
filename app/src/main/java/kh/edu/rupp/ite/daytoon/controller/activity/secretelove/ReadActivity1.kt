package kh.edu.rupp.ite.daytoon.controller.activity.secretelove
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityReadcomicsBinding

class ReadActivity1 : AppCompatActivity() {

    private lateinit var binding : ActivityReadcomicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityReadcomicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnNext1.setOnClickListener {
            var intent = Intent(this@ReadActivity1, ReadActivity2::class.java)
            startActivity(intent)
        }
        binding.btnNext2.setOnClickListener {
            var intent = Intent(this@ReadActivity1, ReadActivity2::class.java)
            startActivity(intent)
        }
    }
}