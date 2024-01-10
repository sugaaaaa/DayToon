package kh.edu.rupp.ite.daytoon.controller.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.daytoon.model.Anime
import kh.edu.rupp.ite.daytoon.databinding.ViewHolderAnimeBinding

class AnimePreviewAdapter : ListAdapter<Anime, AnimePreviewAdapter.AnimeViewHolder>(

    object : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.getId() == newItem.getId()
        }
    }
) {
    interface OnItemClickListener {
        fun onItemClick(storyNovel: Anime, position: Int)
    }
    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderAnimeBinding.inflate(inflater, parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener{
            val adapterPosition = holder.adapterPosition
            listener?.onItemClick(data, adapterPosition)
        }
    }

    inner class AnimeViewHolder(private val listBinding: ViewHolderAnimeBinding) :
        RecyclerView.ViewHolder(listBinding.root) {

        fun bind(data: Anime) {
            with(Picasso.get()) {
                load(data.image).into(listBinding.imgURL)
            }
            listBinding.txtTitle.text = data.getTitle()
            listBinding.txtD.text = data.getSynopsis()
        }
    }
}
