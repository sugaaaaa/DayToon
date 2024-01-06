package kh.edu.rupp.ite.daytoon.controller.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kh.edu.rupp.ite.daytoon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("users")
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        // Check if the user is already logged in
        if (isLoggedIn()) {
            redirectToIndexActivity()
        }

        binding.btnlogin.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val password = binding.passLogin.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "LogIn successful", Toast.LENGTH_SHORT).show()

                            val user = firebaseAuth.currentUser
                            user?.let {
                                // Store user information in the Realtime Database
                                val userReference = database.child(user.uid)
                                userReference.child("email").setValue(email)

                                // Remember the user
                                saveLoginStatus(true)

                                // Continue with starting the IndexActivity
                                redirectToIndexActivity()
                            }
                        } else {
                            Toast.makeText(this, "LogIn Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter email & password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnsinup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    // Check if the user is logged in
    private fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    // Save the login status
    private fun saveLoginStatus(isLoggedIn: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean("isLoggedIn", isLoggedIn)
            apply()
        }
    }
    // Redirect to the IndexActivity
    private fun redirectToIndexActivity() {
        val intent = Intent(this@LoginActivity, IndexActivity::class.java)
        startActivity(intent)
        finish()
    }

}
