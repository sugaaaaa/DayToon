package kh.edu.rupp.ite.daytoon.controller.activity

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingoutBinding
class SingOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingoutBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignOut.setOnClickListener {
            // Sign out the user
            firebaseAuth.signOut()

            // Redirect to the kh.edu.rupp.ite.daytoon.activity.WelcomePageActivity after sign-out
            val intent = Intent(this@SingOutActivity, IndexActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


