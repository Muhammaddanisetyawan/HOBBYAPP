package com.ubaya.hobbyapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ubaya.hobbyapp.R
import com.ubaya.hobbyapp.data.AppDatabase
import com.ubaya.hobbyapp.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            lifecycleScope.launch {
                val user = AppDatabase.getDatabase(applicationContext).userDao().login(username, password)
                if (user != null) {
                    // Navigate to main activity
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Show error
                }
            }
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
