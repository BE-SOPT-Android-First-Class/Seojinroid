package org.sopt.soptseminar_week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.soptseminar_week1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val logTag = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
}