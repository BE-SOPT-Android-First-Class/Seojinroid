package org.sopt.soptseminar_week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.sopt.soptseminar_week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener{
            val userId = binding.idEt.text
            val userPw = binding.pwEt.text
            if(userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(
                    this@MainActivity,
                    "모두 입력해주세요",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "환영합니다",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}