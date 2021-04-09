package org.sopt.soptseminar_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.databinding.ActivityMainBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val logTag = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "Sign In Activity - onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "Sign In Activity - onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "Sign In Activity - onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "Sign In Activity - onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "Sign In Activity - onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "Sign In Activity - onRestart Called")
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener{
            val userId = binding.idEt.text
            val userPw = binding.pwEt.text
            if(userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(
                    this@SignInActivity,
                    "아이디/비밀번호를 확인해주세요!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@SignInActivity,
                    "환영합니다",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        binding.signupButton.setOnClickListener{
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}