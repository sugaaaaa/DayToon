package kh.edu.rupp.ite.daytoon.page

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.LoginActivity
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypeBinding

class TypeStoryActivity: AppCompatActivity(){

    private lateinit var binding: ActivityTypeBinding
    private lateinit var textView: TextView
    private lateinit var selectedLanguage: BooleanArray
    private val langList = ArrayList<Int>()
    private val langArray = arrayOf("modern", "", "Kotlin", "C", "Python", "Javascript")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTypeBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val bottomButton: Button = findViewById(R.id.btnNext)

        bottomButton.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }




    }
}