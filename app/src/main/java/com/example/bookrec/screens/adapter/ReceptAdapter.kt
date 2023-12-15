package com.example.bookrec.screens.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.bookrec.DetailsActivity
import com.example.bookrec.Fragment.MenuReceptowFragment
import com.example.bookrec.databinding.FragmentRecepty2Binding
import com.example.bookrec.databinding.ItemReceptLayoutBinding
import com.example.bookrec.model.PeceptModel
import com.example.bookrec.model.SharedModel

class ReceptAdapter(
    val context : Context,
    val list : ArrayList<PeceptModel>
) : RecyclerView.Adapter<ReceptAdapter.PopylarViewHolder>() {


    private lateinit var sharedModel: SharedModel

    fun setsharedModel(viewModel: SharedModel){
        sharedModel = viewModel
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReceptAdapter.PopylarViewHolder {
        val binding = ItemReceptLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return PopylarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReceptAdapter.PopylarViewHolder, position: Int) {

        val listModel = list[position]

        holder.foodRecept.text = listModel.getFoodRecept()
        holder.foodOpisanie.text = listModel.getFoodOpisanie()
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }

        holder.item.setOnClickListener {
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra("foodImage",listModel.getFoodImage())
            intent.putExtra("foodRecept",listModel.getFoodRecept())
            context.startActivity(intent)
        }

        holder.addBtn.setOnClickListener {

            if (sharedModel.inList(listModel)){
              sharedModel.deleteFromCart(listModel)
              holder.addBtn.setText(" ")

            }else{
              sharedModel.addToCart(listModel)
              holder.addBtn.setText("Like")
            }

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PopylarViewHolder(binding: ItemReceptLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        val foodRecept = binding.homeFoodName
        val foodOpisanie = binding.homeFoodKcall
        val foodImage = binding.homeFoodImage
        val addBtn = binding.likeBottom

        val item = binding.root


    }
}
