package kh.edu.rupp.ite.daytoon.controller.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityChapterBinding

class ChapterActivity : AppCompatActivity () {

    private lateinit var binding: ActivityChapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener {
//            val intent = Intent(this@StoryShowActivity, IndexActivity::class.java)
//            startActivity(intent)
            finish()
        }
    }



}