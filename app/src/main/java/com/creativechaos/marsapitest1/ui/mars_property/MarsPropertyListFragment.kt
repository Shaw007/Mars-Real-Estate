package com.creativechaos.marsapitest1.ui.mars_property


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.creativechaos.marsapitest1.databinding.FragmentMarsPropertyListBinding

/**
 * A simple [Fragment] subclass.
 */
class MarsPropertyListFragment : Fragment() {
    private lateinit var binding: FragmentMarsPropertyListBinding
    private lateinit var marsPropertyViewModel: MarsPropertyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMarsPropertyListBinding.inflate(inflater)

        val activity = requireNotNull(this.activity)

        marsPropertyViewModel = ViewModelProviders.of(this,
            MarsPropertyViewModelFactory(activity.application)).get(MarsPropertyViewModel::class.java)

        binding.recyclerViewMarsProperty.adapter = MarsPropertyListAdapter(MarsPropertyListAdapter.MarsPropertyListListener {

        })

        binding.lifecycleOwner = this
        binding.marsPropertyViewModel = marsPropertyViewModel


        return binding.root
    }


}
