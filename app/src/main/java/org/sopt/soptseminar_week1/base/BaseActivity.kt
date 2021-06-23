package org.sopt.soptseminar_week1.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.sopt.soptseminar_week1.utils.activityLogger

abstract class BaseActivity<B : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B
) : AppCompatActivity() {

    private var _binding: B? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
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
        _binding = null
    }

    override fun onRestart() {
        super.onRestart()
        activityLogger(this.localClassName, "onRestart")
    }
}