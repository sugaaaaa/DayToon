package kh.edu.rupp.ite.daytoon.view.viewmodel.secretelove

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityRead2Binding

class ReadActivity2 :AppCompatActivity() {

    private lateinit var binding : ActivityRead2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRead2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrev.setOnClickListener {
            var intent =  Intent(this@ReadActivity2, ReadActivity1::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            var intent =  Intent(this@ReadActivity2, SecreteLoveActivity::class.java)
            startActivity(intent)
        }
   }
}