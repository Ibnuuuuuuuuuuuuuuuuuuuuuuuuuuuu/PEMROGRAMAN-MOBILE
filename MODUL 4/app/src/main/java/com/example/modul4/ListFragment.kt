package com.example.modul4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul4.databinding.FragmentListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.net.URLEncoder

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OotdViewModel by viewModels { OotdViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.ootdList.collectLatest { ootdList ->
                val adapter = OotdAdapter(ootdList, object : OotdAdapter.OnItemClickListener {
                    override fun onDetailClick(ootd: Ootd) {
                        Log.d("OotdApp", "Tombol Detail ditekan: ${ootd.title}")
                        viewModel.selectOotd(ootd)
                        val bundle = Bundle().apply { putInt("ootdId", ootd.id) }
                        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
                    }

                    override fun onShopClick(ootd: Ootd) {
                        Log.d("OotdApp", "Tombol Shop ditekan: ${ootd.title}")
                        val query = "${ootd.title} ${ootd.style} ${ootd.gender} fashion"
                        val encodedQuery = URLEncoder.encode(query, "UTF-8")
                        val url = "https://shopee.co.id/search?keyword=$encodedQuery"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    }
                })

                binding.recyclerView.layoutManager = LinearLayoutManager(context)
                binding.recyclerView.adapter = adapter

                binding.recyclerView.visibility = if (ootdList.isEmpty()) View.GONE else View.VISIBLE
                binding.emptyView.visibility = if (ootdList.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
