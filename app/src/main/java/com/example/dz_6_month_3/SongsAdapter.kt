package com.example.dz_6_month_3

import android.view.LayoutInflater
import android.widget.Adapter
import com.example.dz_6_month_3.databinding.ItemSongBinding

class SongsAdapter(
    private val list: List<Music>,
    private val onItemClick: (title: String) -> Unit
) : Adapter<SongsAdapter.SongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongsViewHolder(
        ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class SongsViewHolder(private val binding: ItemSongBinding) : ViewHolder(binding.root) {
        fun onBind(music: Music) = with(binding) {
            tvRank.text = music.rank
            tvTitle.text = music.title
            tvAuthor.text = music.author
            tvDuration.text = music.duration
            root.setOnClickListener {
                onItemClick(list[adapterPosition].title)
            }
        }
    }
}