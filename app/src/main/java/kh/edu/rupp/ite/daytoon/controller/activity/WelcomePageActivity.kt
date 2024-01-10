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

        preferencesManager = PreferencesManager(this)

        if (!preferencesManager.isWelcomePageShown) {

            val bottomButton: Button = findViewById(R.id.next)

            bottomButton.setOnClickListener {
                preferencesManager.isWelcomePageShown = true
                startWelcome2Activity()
            }
        } else {
            startIndexActivity()
        }
    }

    private fun startWelcome2Activity() {
        val intent = Intent(this, Welcome2Activity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startIndexActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
