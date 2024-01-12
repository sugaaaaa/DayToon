package kh.edu.rupp.ite.daytoon.controller.activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.daytoon.databinding.ActivityReadcomicsBinding

class ComicsReadActivity : AppCompatActivity() {

    private lateinit var binding : ActivityReadcomicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityReadcomicsBinding.inflate(layoutInflater)
        binding.root
    }
}