package com.ubaya.hobbyapp.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ubaya.hobbyapp.data.AppDatabase
import com.ubaya.hobbyapp.databinding.ActivityNewsDetailBinding
import kotlinx.coroutines.launch

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsId = intent.getIntExtra("news_id", -1)
        if (newsId != -1) {
            lifecycleScope.launch {
                val news = AppDatabase.getDatabase(applicationContext).newsDao().getNewsById(newsId)
                binding.news = news
            }
        }
    }
}