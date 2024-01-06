package kh.edu.rupp.ite.daytoon.controller.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.daytoon.model.StoryNovel
import kh.edu.rupp.ite.daytoon.databinding.ViewHolderStorynovelBinding

class StoryNovelAdapter : ListAdapter<StoryNovel, StoryNovelAdapter.StoryNovelViewHolder>(

    object : DiffUtil.ItemCallback<StoryNovel>() {
        override fun areItemsTheSame(oldItem: StoryNovel, newItem: StoryNovel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: StoryNovel, newItem: StoryNovel): Boolean {
            return newItem.getId() == oldItem.getId()
        }
    }
) {

    interface OnItemClickListener {
        fun onItemClick(storyNovel: StoryNovel, position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryNovelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderStorynovelBinding.inflate(inflater, parent, false)
        return StoryNovelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryNovelViewHolder, position: Int) {
        val storyNovel = getItem(position)
        holder.bind(storyNovel)

        // Set a click listener on the item view.
        holder.itemView.setOnClickListener {
            // Get the position of the clicked item.
            val adapterPosition = holder.adapterPosition

            // Perform the desired action.
            listener?.onItemClick(storyNovel, adapterPosition)
        }
    }
    inner class StoryNovelViewHolder(private val binding: ViewHolderStorynovelBinding) :
        ViewHolder(binding.root) {

        fun bind(storyNovel: StoryNovel) {
            binding.title.text = storyNovel.getTitle()
            binding.description.text = storyNovel.getDescription()
            Picasso.get().load(storyNovel.getImg()).into(binding.image)

        }
    }
}
