package com.example.montypays.authentication

import `in`.mayanknagwanshi.countrypicker.CountrySelectActivity
import `in`.mayanknagwanshi.countrypicker.bean.CountryData
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.montypays.R
import com.example.montypays.databinding.BottomSheetCompanySizeLayoutBinding
import com.example.montypays.databinding.FragmentSignUpBinding
import com.example.montypays.dialogs.CompanySizeBottomSheet
import com.juanpabloprado.countrypicker.CountryPicker


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var bindingBottomSheet: BottomSheetCompanySizeLayoutBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        bindingBottomSheet = BottomSheetCompanySizeLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  initViewModel()
        bindings()
    }

    private fun bindings() {
        binding.ibChooseCountryName.setOnClickListener {
            picker()
        }
        binding.linearLayoutCountry.setOnClickListener {
            picker()
        }
        binding.tvCountry2.setOnClickListener {
            picker()
        }

        binding.edtCountryCode.setOnClickListener {
            intentToPicker()
        }
        binding.ibCountryCodePicker.setOnClickListener {
            intentToPicker()
        }
        binding.ibCompanySize.setOnClickListener {
            navigateToBottomSheet()
        }

        binding.linearLayoutCompanySize.setOnClickListener {
            navigateToBottomSheet()
        }
        binding.tvCompanySize2.setOnClickListener {
            navigateToBottomSheet()
        }

        binding.tvAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }
        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }


    }

    @SuppressLint("ResourceType")
    private fun navigateToBottomSheet() {
        val sheet = CompanySizeBottomSheet()
        sheet.setListener(object : CompanySizeBottomSheet.OnApplyButtonClicked{
            override fun onClick(item: String?) {
                binding.tvCompanySize2.setText(item)
            }
        })
        sheet.show(requireActivity().supportFragmentManager,"BottomSheetDialog")
    }

    private fun intentToPicker() {
        val intent = Intent(requireContext(), CountrySelectActivity::class.java)
        intent.putExtra(
            CountrySelectActivity.EXTRA_SELECTED_COUNTRY,
            CountryData("IN")
        )
        getCountryCodeFromDialog.launch(intent)
    }

    private fun picker() {
        val picker: CountryPicker = CountryPicker.getInstance(
            "Select Country"
        ) { name, _ ->
            binding.tvCountry2.setText(name)
            val dialogFragment: DialogFragment =
                requireActivity().supportFragmentManager.findFragmentByTag("CountryPicker") as DialogFragment
            dialogFragment.dismiss()
        }
        picker.show(requireActivity().supportFragmentManager, "CountryPicker")
    }

    private val getCountryCodeFromDialog = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == Activity.RESULT_OK){
            val countryData =
                it.data!!.getSerializableExtra(CountrySelectActivity.RESULT_COUNTRY_DATA) as CountryData?
            binding.edtCountryCode.text = countryData!!.countryISD
        }
    }
}