package com.example.bookrec.screens.recepty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookrec.R
import com.example.bookrec.model.PeceptModel
import com.example.bookrec.model.SharedModel
import com.example.bookrec.screens.adapter.ReceptAdapter


class ReceptyFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var receptAdapter: ReceptAdapter
    private lateinit var peceptModel: ArrayList<PeceptModel>
    private lateinit var sharedModel: SharedModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recepty2, container, false)


        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        recyclerView = view.findViewById(R.id.recyclerView)

        peceptModel = ArrayList()
        peceptModel.add(PeceptModel("Блины с красной икрой","165ккал",R.drawable.bliny))
        peceptModel.add(PeceptModel("Пирожки с капустой","165ккал",R.drawable.pirochki))
        peceptModel.add(PeceptModel("Оливье с говядиной","108ккал",R.drawable.olivie))
        peceptModel.add(PeceptModel("Борщ Обыкновенный","55ккал",R.drawable.borcsh))
        peceptModel.add(PeceptModel("Осетр запеченный","189ккал",R.drawable.osetr))
        peceptModel.add(PeceptModel("Пельмени домашние","218ккал",R.drawable.pelmeni))
        peceptModel.add(PeceptModel("Винегрет с горошком","69ккал",R.drawable.vinegret))
        peceptModel.add(PeceptModel("Кулеш из пшена","72ккал",R.drawable.kylesh))
        peceptModel.add(PeceptModel("Ватрушка с творогом","293ккал",R.drawable.kingvatryshka))
        peceptModel.add(PeceptModel("Хворост классический","492ккал",R.drawable.hworost))
        peceptModel.add(PeceptModel("Капуста квашеная","28ккал",R.drawable.kapysta))
        peceptModel.add(PeceptModel("Солянка мясная","97ккал",R.drawable.solanka))
        peceptModel.add(PeceptModel("Холодец","137ккал",R.drawable.holodech,))


        receptAdapter = ReceptAdapter(requireContext(),peceptModel)
        receptAdapter.setsharedModel(sharedModel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = receptAdapter





        return view
    }

}