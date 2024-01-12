package kh.edu.rupp.ite.daytoon.controller.activity.secretelove

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.controller.fragment.LibraryFragment
import kh.edu.rupp.ite.daytoon.databinding.ActivitySecreteloveBinding

class SecreteLoveActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecreteloveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecreteloveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecreteLove.setOnClickListener {
            var intent =  Intent(this@SecreteLoveActivity, ReadActivity1::class.java)
            startActivity(intent)
        }

        binding.btnSecreteLoveChapter.setOnClickListener {
            var intent =  Intent(this@SecreteLoveActivity, ChapterActivity::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            var intent =  Intent(this@SecreteLoveActivity, LibraryFragment::class.java)
            startActivity(intent)
        }
    }
}