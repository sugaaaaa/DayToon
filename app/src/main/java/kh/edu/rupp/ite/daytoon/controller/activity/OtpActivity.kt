package kh.edu.rupp.ite.daytoon.controller.activity


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.daytoon.databinding.ActivityOtpBinding
import kotlin.random.nextInt

class OtpActivity: AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding
    lateinit var auth : FirebaseAuth
    var email : String=""
    var pass : String=""
    var random : String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        email=intent.getStringExtra("email").toString()
        pass=intent.getStringExtra("pass").toString()

        binding.otp1.doOnTextChanged { text, start, before, count ->
            if (!binding.otp1.text.toString().isEmpty()){
                binding.otp1.requestFocus()
            }
            if (!binding.otp2.text.toString().isEmpty()){
                binding.otp2.requestFocus()
            }
        }
        binding.otp2.doOnTextChanged { text, start, before, count ->
            if (!binding.otp2.text.toString().isEmpty()){
                binding.otp3.requestFocus()
            }
            else{
                binding.otp1.requestFocus()
            }
        }
        binding.otp3.doOnTextChanged { text, start, before, count ->
            if (!binding.otp3.text.toString().isEmpty()){
                binding.otp4.requestFocus()
            }
            else{
                binding.otp2.requestFocus()
            }
        }
        binding.otp4.doOnTextChanged { text, start, before, count ->
            if (!binding.otp4.text.toString().isEmpty()){
                binding.otp5.requestFocus()
            }
            else{
                binding.otp3.requestFocus()
            }
        }
        binding.otp5.doOnTextChanged { text, start, before, count ->
            if (!binding.otp5.text.toString().isEmpty()){
                binding.otp6.requestFocus()
            }
            else{
                binding.otp4.requestFocus()
            }
        }
        binding.otp6.doOnTextChanged { text, start, before, count ->
            if (binding.otp6.text.toString().isEmpty()){
                binding.otp5.requestFocus()
            }

            binding.bottomdone.setOnClickListener {
                var otp1=binding.otp1.text.toString()
                var otp2=binding.otp2.text.toString()
                var otp3=binding.otp3.text.toString()
                var otp4=binding.otp4.text.toString()
                var otp5=binding.otp5.text.toString()
                var otp6=binding.otp6.text.toString()

                var otp="$otp1$otp2$otp3$otp4$otp5$otp6"

                if (binding.otp1.text.toString().isEmpty()||
                    binding.otp2.text.toString().isEmpty()||
                    binding.otp3.text.toString().isEmpty()||
                    binding.otp4.text.toString().isEmpty()||
                    binding.otp5.text.toString().isEmpty()||
                    binding.otp6.text.toString().isEmpty()){

                    Toast.makeText(this@OtpActivity, "Enter OTP", Toast.LENGTH_SHORT).show()
                }
                else if(!otp.equals(random.toString())){
                }
            }
        }
    }
     fun random(){
         random= kotlin.random.Random.nextInt(100000..999999).toString()
     }
}
