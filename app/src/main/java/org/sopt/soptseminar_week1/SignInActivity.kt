package org.sopt.soptseminar_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.databinding.ActivityMainBinding
import org.sopt.soptseminar_week1.utils.activityLogger

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var signUpActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from SignUp Activity")
    }
    private var homeActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from Home Activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()
    }

    override fun onStart() {
        super.onStart()
        activityLogger(this.localClassName, "onStart")
    }

    override fun onResume() {
        super.onResume()
        activityLogger(this.localClassName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        activityLogger(this.localClassName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        activityLogger(this.localClassName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        activityLogger(this.localClassName, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        activityLogger(this.localClassName, "onRestart")
    }

    private fun isLoginEditTextEmpty() = binding.editTextId.text.isNullOrBlank() || binding.editTextPw.text.isNullOrBlank()

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            if (isLoginEditTextEmpty()) {
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
                homeActivityLauncher.launch(intent)
            }
        }
        binding.signupButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
}