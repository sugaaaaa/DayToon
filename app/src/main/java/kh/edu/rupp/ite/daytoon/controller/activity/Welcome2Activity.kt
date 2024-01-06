package kh.edu.rupp.ite.daytoon.controller.activity

import kh.edu.rupp.ite.daytoon.view.viewmodel.PreferencesManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActicityWelcome2Binding

class Welcome2Activity : AppCompatActivity() {

    private lateinit var binding: ActicityWelcome2Binding
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActicityWelcome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize kh.edu.rupp.ite.daytoon.viewmodel.PreferencesManager
        preferencesManager = PreferencesManager(this)

        // Check if the welcome page has been shown
        if (!preferencesManager.isWelcomeShown) {
            // It's the first time, show the welcome page

            binding.next.setOnClickListener {
                // Save the flag indicating that the welcome page has been shown
                preferencesManager.isWelcomeShown = true
                // Launch the kh.edu.rupp.ite.daytoon.activity.TypeStoryActivity for the first time
                startTypeStoryActivity()
            }
        } else {
            // It's not the first time, redirect to LoginActivity
            startLoginActivity()
        }
    }

    private fun startTypeStoryActivity() {
        // Launch the kh.edu.rupp.ite.daytoon.activity.TypeStoryActivity for the first time
        val intent = Intent(this, TypeStoryActivity::class.java)
        startActivity(intent)
        finish() // Optional: finish the current activity if you don't want the user to come back to it
    }

    private fun startLoginActivity() {
        // Launch the LoginActivity if the user is not logged in or signed up
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: finish the current activity if you don't want the user to come back to it
    }
}
