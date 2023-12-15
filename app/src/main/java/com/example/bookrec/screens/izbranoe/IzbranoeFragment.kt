package com.example.bookrec.screens.izbranoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookrec.R
import com.example.bookrec.databinding.FragmentIzbranoeBinding
import com.example.bookrec.model.PeceptModel
import com.example.bookrec.model.SharedModel
import com.example.bookrec.screens.adapter.IzbranoeAdapter


class IzbranoeFragment : Fragment() {

    private lateinit var binding: FragmentIzbranoeBinding
    private lateinit var adapter: IzbranoeAdapter
    private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentIzbranoeBinding.inflate(inflater,container,false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        adapter = IzbranoeAdapter(requireContext(),sharedModel.cartItem.value ?: ArrayList())

        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRv.adapter = adapter


        return binding.root
    }

}