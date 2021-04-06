package org.sopt.soptseminar_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.soptseminar_week1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val logTag = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "Sign Up Activity - onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "Sign Up Activity - onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "Sign Up Activity - onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "Sign Up Activity - onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "Sign Up Activity - onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "Sign Up Activity - onRestart Called")
    }

    private fun initButtonClickEvent() {
        binding.signupButton.setOnClickListener{
            val userName = binding.nmEt.text
            val userId = binding.idEt.text
            val userPw = binding.pwEt.text
            if(userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                var bundle = Bundle();
                bundle.putString("username", userName.toString())
                bundle.putString("userId", userId.toString())
                bundle.putString("userPw", userPw.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}