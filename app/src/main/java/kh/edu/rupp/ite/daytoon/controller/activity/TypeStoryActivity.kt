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

        preferencesManager = PreferencesManager(this)

        if (!preferencesManager.isIntroShown) {
            selectedGenres = mutableSetOf()

            binding.btnNext.setOnClickListener {
                preferencesManager.isIntroShown = true
                startLoginActivity()
            }

            val buttonIds = listOf(
                R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10
            )

            for (buttonId in buttonIds) {
                setButtonClickListener(buttonId)
            }
        } else {
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
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
