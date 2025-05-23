package com.example.modul4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.modul4.databinding.FragmentDetailBinding
import java.net.URLEncoder

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OotdViewModel by activityViewModels { OotdViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ootd = viewModel.selectedOotd.value
        if (ootd != null) {
            Log.d("OotdApp", "Navigasi ke DetailFragment dengan item: ${ootd.title}")
            binding.ootdTitle.text = ootd.title
            binding.ootdGender.text = ootd.gender
            binding.ootdStyle.text = ootd.style
            binding.ootdDescription.text = ootd.description
            binding.ootdImage.setImageResource(ootd.imageResId)

            binding.btnShop.setOnClickListener {
                val query = "${ootd.title} ${ootd.style} ${ootd.gender} fashion"
                val encodedQuery = URLEncoder.encode(query, "UTF-8")
                val url = "https://shopee.co.id/search?keyword=$encodedQuery"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}