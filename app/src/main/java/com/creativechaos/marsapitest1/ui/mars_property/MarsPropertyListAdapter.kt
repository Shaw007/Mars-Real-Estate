package com.creativechaos.marsapitest1.ui.mars_property

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.creativechaos.marsapitest1.databinding.MarsPropertyGridItemBinding
import com.creativechaos.marsapitest1.model.MarsProperty

class MarsPropertyListAdapter(val marsPropertyListListener: MarsPropertyListListener): ListAdapter<MarsProperty,RecyclerView.ViewHolder>(MarsPropertyListDiffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MarsPropertyListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val marsProperty = getItem(position)
        when(holder){
            is MarsPropertyListViewHolder -> {
                holder.bind(marsProperty,marsPropertyListListener)
            }
        }
    }

    class MarsPropertyListViewHolder(val binding: MarsPropertyGridItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(marsProperty: MarsProperty,marsPropertyListListener: MarsPropertyListListener){
            binding.marsProperty = marsProperty
            binding.marsPropertyListListener = marsPropertyListListener
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): MarsPropertyListViewHolder{
                return MarsPropertyListViewHolder(MarsPropertyGridItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    object MarsPropertyListDiffUtil: DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem == newItem
        }

    }

    class MarsPropertyListListener(val clickListener: (marsProperty: MarsProperty) -> Unit){
        fun onMarsPropertyClick(marsProperty: MarsProperty) = clickListener(marsProperty)
    }
}







