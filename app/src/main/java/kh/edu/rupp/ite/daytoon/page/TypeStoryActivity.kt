package kh.edu.rupp.ite.daytoon.page

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.LoginActivity
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypeBinding

class TypeStoryActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTypeBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val bottomButton: Button = findViewById(R.id.btnNext)
        val btnmodern: Button = findViewById(R.id.btnmodern)
        val btnaction: Button = findViewById(R.id.btnaction)

        // Set click listeners for each button
        btnmodern.setOnClickListener(this)
        btnaction.setOnClickListener(this)

        bottomButton.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnmodern -> {
                // Handle click for Button 1
                // For example, navigate to another activity
                // val intent = Intent(this, AnotherActivity::class.java)
                // startActivity(intent)
            }
            R.id.btnaction -> {
                // Handle click for Button 2
            }
            // Add more cases for additional buttons
        }
    }
}