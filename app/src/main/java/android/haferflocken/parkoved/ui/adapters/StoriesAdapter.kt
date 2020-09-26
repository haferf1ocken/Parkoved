package android.haferflocken.parkoved.ui.adapters

import android.haferflocken.parkoved.databinding.ItemStoriesBinding
import android.haferflocken.parkoved.models.Story
import android.haferflocken.parkoved.models.Ticket
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class StoriesAdapter(private val clickListener: StoriesListener) :
    ListAdapter<Story, StoriesViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        return StoriesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val storyItem = getItem(position)
        holder.bind(storyItem, clickListener)
    }
}

class StoriesViewHolder private constructor(private val binding: ItemStoriesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Story, clickListener: StoriesListener) {
        binding.story = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): StoriesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemStoriesBinding.inflate(layoutInflater, parent, false)
            return StoriesViewHolder(binding)
        }
    }
}

class StoriesListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(story: Story) = clickListener(story.storyId)
}