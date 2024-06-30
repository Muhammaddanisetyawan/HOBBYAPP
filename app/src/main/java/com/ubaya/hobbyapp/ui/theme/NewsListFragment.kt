package com.ubaya.hobbyapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.hobbyapp.data.AppDatabase
import com.ubaya.hobbyapp.databinding.FragmentNewsListBinding
import kotlinx.coroutines.launch

class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            val newsList = AppDatabase.getDatabase(requireContext()).newsDao().getAllNews()
            binding.recyclerView.adapter = NewsAdapter(newsList) { news ->
                val intent = Intent(context, NewsDetailActivity::class.java).apply {
                    putExtra("news_id", news.id)
                }
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
