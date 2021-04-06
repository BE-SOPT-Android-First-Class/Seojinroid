package org.sopt.soptseminar_week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.sopt.soptseminar_week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val logTag = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "Home Activity - onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "Home Activity - onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "Home Activity - onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "Home Activity - onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "Home Activity - onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logTag, "Home Activity - onRestart Called")
    }
}