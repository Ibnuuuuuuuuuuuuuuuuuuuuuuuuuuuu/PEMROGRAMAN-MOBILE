package com.example.modul4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modul4.databinding.ItemOotdBinding

class OotdAdapter(private val ootdList: List<Ootd>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<OotdAdapter.OotdViewHolder>() {

    interface OnItemClickListener {
        fun onDetailClick(ootd: Ootd)
        fun onShopClick(ootd: Ootd)
    }

    inner class OotdViewHolder(private val binding: ItemOotdBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ootd: Ootd) {
            binding.ootdTitle.text = ootd.title
            binding.ootdGender.text = ootd.gender
            binding.ootdStyle.text = ootd.style
            binding.ootdDescription.text = ootd.description
            binding.ootdImage.setImageResource(ootd.imageResId)

            binding.btnImdb.setOnClickListener {
                listener.onShopClick(ootd)
            }

            binding.btnDetail.setOnClickListener {
                listener.onDetailClick(ootd)
            }

            val imageContentDesc = itemView.context.getString(
                R.string.ootd_image_content_description,
                ootd.title,
                ootd.gender
            )
            binding.ootdImage.contentDescription = imageContentDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OotdViewHolder {
        val binding = ItemOotdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OotdViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OotdViewHolder, position: Int) {
        holder.bind(ootdList[position])
    }

    override fun getItemCount(): Int = ootdList.size
}
