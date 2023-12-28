package kh.edu.rupp.ite.daytoon.page

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.LoginActivity
import kh.edu.rupp.ite.daytoon.R
import androidx.core.content.ContextCompat
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypeBinding
import kh.edu.rupp.ite.daytoon.databinding.ActivityTypestoryBinding

class TypeStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTypestoryBinding
    private lateinit var selectedGenres: MutableSet<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTypestoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize selectedGenres set
        selectedGenres = mutableSetOf()

        // Set click listener for the "Next" button
        binding.btnNext.setOnClickListener {
            // Launch the SelectGenresActivity to allow the user to select genres
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Set up button click listeners and submit button click listener
        val buttonIds = listOf(
            R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10
        )

        for (buttonId in buttonIds) {
            setButtonClickListener(buttonId)
        }

//        binding.btnNext.setOnClickListener {
//            displaySelectedGenres()
//        }
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
    private fun displaySelectedGenres() {
        if (selectedGenres.isNotEmpty()) {
            val selectedGenresText = selectedGenres.joinToString(", ")
            Toast.makeText(this, "Selected: $selectedGenresText", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No genres selected", Toast.LENGTH_SHORT).show()
        }
    }
}
