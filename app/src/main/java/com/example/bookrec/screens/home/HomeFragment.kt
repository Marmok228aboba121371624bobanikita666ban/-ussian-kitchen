package com.example.bookrec.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookrec.R
import com.example.bookrec.model.PeceptModel
import com.example.bookrec.screens.adapter.ReceptAdapter


class HomeFragment : Fragment() {

    private lateinit var adapter:ReceptAdapter
    private lateinit var menuList:ArrayList<PeceptModel>
    private lateinit var menuRv:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recepty, container, false)


        menuList = ArrayList()
        menuList.add(PeceptModel("Блины с красной икрой","165ккал",R.drawable.bliny))
        menuList.add(PeceptModel("Пирожки с капустой","165ккал",R.drawable.pirochki))
        menuList.add(PeceptModel("Оливье с говядиной","108ккал",R.drawable.olivie))
        menuList.add(PeceptModel("Борщ Обыкновенный","55ккал",R.drawable.borcsh))
        menuList.add(PeceptModel("Осетр запеченный","189ккал",R.drawable.osetr))
        menuList.add(PeceptModel("Пельмени домашние","218ккал",R.drawable.pelmeni))
        menuList.add(PeceptModel("Винегрет с горошком","69ккал",R.drawable.vinegret))
        menuList.add(PeceptModel("Кулеш из пшена","72ккал",R.drawable.kylesh))
        menuList.add(PeceptModel("Ватрушка с творогом","293ккал",R.drawable.kingvatryshka))
        menuList.add(PeceptModel("Хворост классический","492ккал",R.drawable.hworost))

        adapter = ReceptAdapter(requireContext(),menuList)
        menuRv = view.findViewById(R.id.menu_Rv)
        menuRv.layoutManager = LinearLayoutManager(requireContext())
        menuRv.adapter = adapter

        return view
    }


}