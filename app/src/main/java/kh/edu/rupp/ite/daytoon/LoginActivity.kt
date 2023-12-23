package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.daytoon.databinding.ActivityLoginBinding
import kh.edu.rupp.ite.daytoon.page.IndexActivity
import kh.edu.rupp.ite.daytoon.page.WelcomePageActivity

class LoginActivity: AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding
  private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root);

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnlogin.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val password = binding.passLogin.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){ task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"LogIn successful",Toast.LENGTH_SHORT).show()
                            var intent= Intent(this@LoginActivity , IndexActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,"LogIn Failed",Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Please enter email & password",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnsinup.setOnClickListener {
            var intent= Intent(this@LoginActivity, SingUpActivity::class.java)
            startActivity(intent)
        }
        binding.nextLogin.setOnClickListener {
            var intent = Intent(this@LoginActivity , WelcomePageActivity::class.java)
            startActivity(intent)
        }
    }
}