package com.example.montypays.authentication

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.montypays.R
import com.example.montypays.authentication.data.authnetwork.ApiInstance
import com.example.montypays.authentication.data.authnetwork.Resource
import com.example.montypays.authentication.data.authrepositories.AuthRepository
import com.example.montypays.authentication.viewmodel.AuthenticationViewModel
import com.example.montypays.databinding.FragmentLogInBinding
import com.example.montypays.utils.toast

class LogInFragment :
    BaseFragment<AuthenticationViewModel, FragmentLogInBinding, AuthRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
//                    lifecycleScope.launch {
//                        userPreferences.saveAuthToken(it.value.data.token)
//                    }
                    toast(it.toString())
                }
                is Resource.Failure -> {
                    toast(it.toString())
                }
            }
        }
        binding.btLogin.setOnClickListener {
            val userName = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            viewModel.login(userName, password)
        }


        binding.edtPassword.doOnTextChanged { _, _, _, _ ->
            binding.linearLayout2.helperText = ""
        }
        binding.edtUsername.doOnTextChanged { _, _, _, _ ->
            binding.linearLayout2.helperText = ""
        }

        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
        binding.tvAccount.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }

        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forgotPasswordFragment)
        }
        underlineLoginTexts()
    }

    override fun getViewModel() = AuthenticationViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLogInBinding.inflate(inflater, container, false)


    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(ApiInstance::class.java))

    private fun underlineLoginTexts() {
        val content = SpannableString("Forgot Password?")
        val contentTerms = SpannableString("Terms and Conditions")
        val contentSignUp = SpannableString("Sign Up Account ")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        contentTerms.setSpan(UnderlineSpan(), 0, contentTerms.length, 0)
        contentSignUp.setSpan(UnderlineSpan(), 0, contentSignUp.length, 0)
        binding.tvForgotPassword.text = content
        binding.tvTermsCondition.text = contentTerms
        binding.tvAccount.text = contentSignUp
    }

}

//
//    private fun onLoginButtonClicked(){
//        binding.btLogin.setOnClickListener {
//            val shake = AnimationUtils.loadAnimation(context, R.anim.shake)
//            val userName = binding.edtUsername.text.toString()
//            val password = binding.edtPassword.text.toString()
//            authViewModel.authListener?.onStarted()
//            if (userName.isEmpty() && password.isEmpty()) {
//                authViewModel.authListener?.onFailure("Invalid email or password")
//                binding.linearLayout.startAnimation(shake)
//                binding.linearLayout2.startAnimation(shake)
//                binding.linearLayout2.helperText =
//                    "The username or password you entered is incorrect."
//                binding.linearLayout2.setHelperTextColor(ColorStateList.valueOf(Color.RED))
//                return@setOnClickListener
//
//            }
//            if (userName.isEmpty() && password.isNotEmpty()) {
//                authViewModel.authListener?.onFailure("Invalid email or password")
//                binding.linearLayout.startAnimation(shake)
//                return@setOnClickListener
//            } else if (password.isEmpty() && userName.isNotEmpty()) {
//                authViewModel.authListener?.onFailure("Invalid email or password")
//                binding.linearLayout2.startAnimation(shake)
//                return@setOnClickListener
//            }
//            authViewModel.loginUser(userName, password)
//        }
//    }
