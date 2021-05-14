package org.sopt.soptseminar_week1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.api.RequestSignIn
import org.sopt.soptseminar_week1.api.ResponseSignIn
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.databinding.ActivityMainBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import org.sopt.soptseminar_week1.utils.isAllEditTextFilled
import org.sopt.soptseminar_week1.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private fun handleEmptyInputs() {
        toast("아이디/비밀번호를 확인해주세요!")
    }

    private fun handleSignInSuccess() {
        toast("환영합니다")
        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
        homeActivityLauncher.launch(intent)
    }

    private fun handleSignInFailure() {
        toast("다시 시도해주세요")
    }

    private fun handleSignInRequest() {
        val requestSignInData = RequestSignIn(
            email = binding.editTextId.text.toString(),
            password = binding.editTextPw.text.toString()
        )
        val call: Call<ResponseSignIn> =
            RetrofitServiceCreator.userService.postSignIn(requestSignInData)

        call.enqueue(object : Callback<ResponseSignIn> {
            override fun onResponse(
                call: Call<ResponseSignIn>,
                response: Response<ResponseSignIn>
            ) {
                Log.d("로그", "${response}, ${response.code()}")
                when (response.code()) {
                    200 -> handleSignInSuccess()
                    else -> handleSignInFailure()
                }
            }

            override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                Log.d("로그", t.toString())
                handleSignInFailure()
            }

        })

    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            if (!isAllEditTextFilled(listOf(binding.editTextId.text, binding.editTextPw.text))) {
                handleEmptyInputs()
            } else {
                handleSignInRequest()
            }
        }
        binding.signupButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
}