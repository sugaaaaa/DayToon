package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingupBinding

class SingUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("users")

        binding.singup.setOnClickListener {
            val name = binding.nameET.text.toString()
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Get the current user's UID
                            val user = firebaseAuth.currentUser
                            user?.let {
                                // Store user information in the Realtime Database
                                val userReference = databaseReference.child(user.uid)
                                userReference.child("name").setValue(name)
                                userReference.child("email").setValue(email)

                                Toast.makeText(this, "SignUp successful", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@SingUpActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        } else {
                            Toast.makeText(this, "SignUp unsuccessful", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textlogin.setOnClickListener {
            val intent = Intent(this@SingUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
