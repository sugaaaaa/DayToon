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

        preferencesManager = PreferencesManager(this)
        if (!preferencesManager.isWelcomeShown) {

            binding.next.setOnClickListener {
                preferencesManager.isWelcomeShown = true
                startTypeStoryActivity()
            }
        } else {
            startLoginActivity()
        }
    }
    private fun startTypeStoryActivity() {
        val intent = Intent(this, TypeStoryActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
