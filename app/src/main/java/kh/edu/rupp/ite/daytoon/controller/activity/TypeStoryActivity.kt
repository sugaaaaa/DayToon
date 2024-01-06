package kh.edu.rupp.ite.daytoon.controller.activity

import kh.edu.rupp.ite.daytoon.view.viewmodel.PreferencesManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypestoryBinding

class TypeStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTypestoryBinding
    private lateinit var selectedGenres: MutableSet<String>
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTypestoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize kh.edu.rupp.ite.daytoon.viewmodel.PreferencesManager
        preferencesManager = PreferencesManager(this)

        // Check if the introduction has been shown
        if (!preferencesManager.isIntroShown) {
            // It's the first time, show the introduction

            // Initialize selectedGenres set
            selectedGenres = mutableSetOf()

            // Set click listener for the "Next" button
            binding.btnNext.setOnClickListener {
                // Save the flag indicating that the introduction has been shown
                preferencesManager.isIntroShown = true
                // Launch the LoginActivity to allow the user to continue
                startLoginActivity()
            }

            // Set up button click listeners and submit button click listener
            val buttonIds = listOf(
                R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10
            )

            for (buttonId in buttonIds) {
                setButtonClickListener(buttonId)
            }
        } else {
            // It's not the first time, redirect to LoginActivity
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        // Launch the LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: finish the current activity if you don't want the user to come back to it
    }

    private fun setButtonClickListener(buttonId: Int) {
        binding.root.findViewById<Button>(buttonId).setOnClickListener {
            toggleSelection(it as Button)
        }
    }

    private fun toggleSelection(button: Button) {
        val genre = button.text.toString()
        if (selectedGenres.contains(genre)) {
            selectedGenres.remove(genre)
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
        } else {
            selectedGenres.add(genre)
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.Green))
        }
    }
}
