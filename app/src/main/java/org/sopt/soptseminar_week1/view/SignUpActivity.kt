package org.sopt.soptseminar_week1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.databinding.ActivitySignUpBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import org.sopt.soptseminar_week1.utils.isAllEditTextFilled

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var loginActivityLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from LogIn Activity")
    }

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

    private fun initButtonClickEvent() {
        binding.signupButton.setOnClickListener {
            val userName = binding.editTextName.text
            val userId = binding.editTextId.text
            val userPw = binding.editTextPw.text
            if (!isAllEditTextFilled(listOf(userName, userId, userPw))) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignUpActivity, "회원가입을 축하합니다!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                val bundle = Bundle()
                bundle.putString("username", userName.toString())
                bundle.putString("userId", userId.toString())
                bundle.putString("userPw", userPw.toString())
                intent.putExtras(bundle)
                loginActivityLauncher.launch(intent)
            }
        }
    }
}