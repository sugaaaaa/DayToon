package kh.edu.rupp.ite.daytoon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.daytoon.databinding.ActivitySingupBinding

class SingUpActivity: AppCompatActivity() {
  private lateinit var binding: ActivitySingupBinding
  private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root);

        firebaseAuth = FirebaseAuth.getInstance()
        binding.singup.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){ task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"singUp successful",Toast.LENGTH_SHORT).show()
                            var intent= Intent(this@SingUpActivity , LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,"singUp unsuccessful",Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Enter Email and Password",Toast.LENGTH_SHORT).show()
            }
        }
        binding.textlogin.setOnClickListener {
            var intent = Intent(this@SingUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}