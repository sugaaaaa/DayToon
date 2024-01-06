package kh.edu.rupp.ite.daytoon.controller.activity

import kh.edu.rupp.ite.daytoon.view.viewmodel.PreferencesManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.R
import kh.edu.rupp.ite.daytoon.databinding.ActicityWelcomeBinding

class WelcomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActicityWelcomeBinding
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActicityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize kh.edu.rupp.ite.daytoon.viewmodel.PreferencesManager
        preferencesManager = PreferencesManager(this)

        // Check if the welcome page has been shown
        if (!preferencesManager.isWelcomePageShown) {
            // It's the first time, show the welcome page

            val bottomButton: Button = findViewById(R.id.next)

            bottomButton.setOnClickListener {
                // Save the flag indicating that the welcome page has been shown
                preferencesManager.isWelcomePageShown = true
                // Launch the kh.edu.rupp.ite.daytoon.activity.Welcome2Activity
                startWelcome2Activity()
            }
        } else {
            // It's not the first time, redirect to IndexActivity
            startIndexActivity()
        }
    }

    private fun startWelcome2Activity() {
        // Launch the kh.edu.rupp.ite.daytoon.activity.Welcome2Activity
        val intent = Intent(this, Welcome2Activity::class.java)
        startActivity(intent)
        finish() // Optional: finish the current activity if you don't want the user to come back to it
    }

    private fun startIndexActivity() {
        // Redirect the user to IndexActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: finish the current activity if you don't want the user to come back to it
    }
}
