package org.sopt.soptseminar_week1.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.databinding.FragmentAutoSignInDialogBinding

class AutoSignInDialogFragment(private val userId: String, private val userPw: String) :
    DialogFragment() {
    private lateinit var binding: FragmentAutoSignInDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentAutoSignInDialogBinding.inflate(LayoutInflater.from(context))
        initView()
        return AlertDialog.Builder(requireActivity()).setView(binding.root).create()
    }

    private fun initView() {
        binding.textAutoSigninId.text = userId
        val selectorSentence = "${userId}(으)로\n로그인하시겠습니까?"
        binding.textAutoSigninSelector.text = selectorSentence
        Glide.with(this).load("https://github.com/${userId}.png").into(binding.imgAutoSigninProfile)

        binding.signupNoButton.setOnClickListener { dismiss() }
        binding.signupButton.setOnClickListener {
            (activity as SignInActivity).handleSignInRequest(
                email = userId,
                password = userPw
            )
        }
    }

}