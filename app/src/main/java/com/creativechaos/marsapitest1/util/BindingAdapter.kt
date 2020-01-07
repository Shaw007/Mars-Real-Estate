package com.creativechaos.marsapitest1.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.creativechaos.marsapitest1.R
import com.creativechaos.marsapitest1.databinding.FragmentMarsPropertyListBinding
import com.creativechaos.marsapitest1.model.MarsProperty
import com.creativechaos.marsapitest1.ui.mars_property.MarsPropertyListAdapter

@BindingAdapter("marsPropertyListData")
fun RecyclerView.setMarsPropertyListData(marsProperties: List<MarsProperty>?){
    marsProperties?.let {
        val adapter = adapter as MarsPropertyListAdapter
        adapter.submitList(marsProperties)
    }
}

@BindingAdapter("propertyImageUrl")
fun ImageView.setPropertyImageSourceUrl(marsProperty: MarsProperty?){
    marsProperty?.imgSrcUrl?.let {
        val imgUri = marsProperty.imgSrcUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(imgUri)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
            .into(this)
    }
}