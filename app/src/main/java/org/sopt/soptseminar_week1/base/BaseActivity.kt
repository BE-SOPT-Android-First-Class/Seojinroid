package org.sopt.soptseminar_week1.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.sopt.soptseminar_week1.utils.activityLogger

abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
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
}