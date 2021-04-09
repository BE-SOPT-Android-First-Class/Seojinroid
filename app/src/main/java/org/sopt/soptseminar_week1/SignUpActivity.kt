package org.sopt.soptseminar_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.sopt.soptseminar_week1.databinding.ActivitySignUpBinding
import org.sopt.soptseminar_week1.utils.activityLogger

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
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

    private fun isSignUpEditTextEmpty() = binding.editTextId.text.isNullOrBlank() || binding.editTextName.text.isNullOrBlank() || binding.editTextPw.text.isNullOrBlank()

    private fun initButtonClickEvent() {
        binding.signupButton.setOnClickListener {
            val userName = binding.editTextName.text.toString()
            val userId = binding.editTextId.text.toString()
            val userPw = binding.editTextPw.text.toString()
            if (isSignUpEditTextEmpty()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignUpActivity, "회원가입을 축하합니다!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                val bundle = Bundle()
                bundle.putString("username", userName)
                bundle.putString("userId", userId)
                bundle.putString("userPw", userPw)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}