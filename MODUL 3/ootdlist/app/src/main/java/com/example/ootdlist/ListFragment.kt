package com.example.ootdlist.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ootdlist.R
import com.example.ootdlist.adapter.OotdAdapter
import com.example.ootdlist.data.Ootd
import com.example.ootdlist.databinding.FragmentListBinding
import java.net.URLEncoder

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ootdList = Ootd.ootdList
        val adapter = OotdAdapter(ootdList, object : OotdAdapter.OnItemClickListener {
            override fun onDetailClick(ootd: Ootd) {
                val bundle = Bundle().apply {
                    putInt("ootdId", ootd.id)
                }
                findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }

            override fun onShopClick(ootd: Ootd) {
                val searchQuery = "${ootd.title} ${ootd.style} ${ootd.gender} fashion"
                val encodedQuery = URLEncoder.encode(searchQuery, "UTF-8")
                val url = "https://shopee.co.id/search?keyword=$encodedQuery"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        if (ootdList.isEmpty()) {
            binding.recyclerView.visibility = View.GONE
            binding.emptyView.visibility = View.VISIBLE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            binding.emptyView.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
