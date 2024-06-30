package com.ubaya.hobbyapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ubaya.hobbyapp.R
import com.ubaya.hobbyapp.data.AppDatabase
import com.ubaya.hobbyapp.data.entities.User
import com.ubaya.hobbyapp.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            val user = User(username = username, email = email, password = password)

            lifecycleScope.launch {
                AppDatabase.getDatabase(applicationContext).userDao().insert(user)
                // Navigate to login activity
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
