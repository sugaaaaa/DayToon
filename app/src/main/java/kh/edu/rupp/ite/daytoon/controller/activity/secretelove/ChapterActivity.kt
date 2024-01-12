package kh.edu.rupp.ite.daytoon.controller.activity.secretelove

import android.content.Intent
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
            finish()
        }
        binding.chapter1Layout.setOnClickListener {
            val intent = Intent( this@ChapterActivity, ReadActivity1::class.java)
            startActivity( intent)
        }


    }
}