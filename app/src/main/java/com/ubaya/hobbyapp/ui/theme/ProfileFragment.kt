package com.ubaya.hobbyapp.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ubaya.hobbyapp.data.AppDatabase
import com.ubaya.hobbyapp.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val user = AppDatabase.getDatabase(requireContext()).userDao().getUser()
            binding.user = user
        }

        binding.btnChangePassword.setOnClickListener {
            // Handle change password
        }

        binding.btnLogout.setOnClickListener {
            // Handle logout
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}