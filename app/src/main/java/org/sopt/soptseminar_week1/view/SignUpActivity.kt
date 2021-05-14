package org.sopt.soptseminar_week1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.api.RequestSignUp
import org.sopt.soptseminar_week1.api.ResponseSignUp
import org.sopt.soptseminar_week1.api.UserServiceCreator
import org.sopt.soptseminar_week1.databinding.ActivitySignUpBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import org.sopt.soptseminar_week1.utils.isAllEditTextFilled
import org.sopt.soptseminar_week1.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private fun handleSignUpSuccess() {
        toast("회원가입을 축하합니다! 로그인해주세요")
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        loginActivityLauncher.launch(intent)
    }

    private fun handleSignUpFailure() {
        toast("다시 시도해 주세요~!")
    }

    private fun handleSignUpRequest() {

        val requestSignUpData: RequestSignUp = RequestSignUp(
            email = binding.editTextId.text.toString(),
            password = binding.editTextPw.text.toString(),
            nickname = binding.editTextName.text.toString(),
            sex = if (binding.radioSex.checkedRadioButtonId == R.id.radio_sex_male) 0 else 1,
            phone = binding.editTextPhone.text.toString(),
            birth = "${binding.datepickerBirth.year}-${binding.datepickerBirth.month}-${binding.datepickerBirth.dayOfMonth}"
        )

        val call: Call<ResponseSignUp> =
            UserServiceCreator.userService.postSignUp(requestSignUpData)
        call.enqueue(object : Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                Log.d("로그", "${response}, ${response.code()}")
                when (response.code()) {
                    200 -> handleSignUpSuccess()
                    else -> handleSignUpFailure()
                }
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.d("로그", t.toString())
                handleSignUpFailure()
            }
        })
    }

    private fun initButtonClickEvent() {
        binding.signupButton.setOnClickListener {
            val userName = binding.editTextName.text
            val userId = binding.editTextId.text
            val userPw = binding.editTextPw.text
            val userPhone = binding.editTextPhone.text
            if (!isAllEditTextFilled(listOf(userName, userId, userPw, userPhone))) {
                toast("빈 칸이 있는지 확인해주세요")
            } else {
                handleSignUpRequest()
            }
        }
    }
}