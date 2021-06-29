package org.sopt.soptseminar_week1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.base.BaseActivity
import org.sopt.soptseminar_week1.data.RequestSignIn
import org.sopt.soptseminar_week1.data.ResponseSignIn
import org.sopt.soptseminar_week1.data.UserAuthStorage
import org.sopt.soptseminar_week1.databinding.ActivityMainBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import org.sopt.soptseminar_week1.utils.isAllEditTextFilled
import org.sopt.soptseminar_week1.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
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
        searchUserAuthStorage()
        initButtonClickEvent()
    }

    private fun isUserDataSaved() =
        UserAuthStorage.getUserId(this).isNotEmpty() && UserAuthStorage.getUserPw(this).isNotEmpty()

    private fun searchUserAuthStorage() {
        if (isUserDataSaved()) {
            AutoSignInDialogFragment(
                UserAuthStorage.getUserId(this@SignInActivity),
                UserAuthStorage.getUserPw(this@SignInActivity)
            ).show(
                supportFragmentManager,
                "Dialog"
            )
        }
    }

    private fun handleEmptyInputs() {
        toast("아이디/비밀번호를 확인해주세요!")
    }

    private fun handleSignInSuccess() {
        toast("환영합니다")
        if (isAllEditTextFilled(listOf(binding.editTextId.text, binding.editTextPw.text))) {
            UserAuthStorage.saveUserId(this@SignInActivity, binding.editTextId.text.toString())
            UserAuthStorage.saveUserPw(this@SignInActivity, binding.editTextPw.text.toString())
        }
        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
        homeActivityLauncher.launch(intent)
    }

    private fun handleSignInFailure() {
        toast("다시 시도해주세요")
    }

    fun handleSignInRequest(email: String, password: String) {
        val requestSignInData = RequestSignIn(
            email = email,
            password = password
        )
        val call: Call<ResponseSignIn> =
            RetrofitServiceCreator.getUserService().postSignIn(requestSignInData)

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
                handleSignInRequest(
                    email = binding.editTextId.text.toString(),
                    password = binding.editTextPw.text.toString()
                )
            }
        }
        binding.signupButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
}