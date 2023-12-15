package com.example.bookrec.screens.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookrec.databinding.CartAddItemBinding
import com.example.bookrec.databinding.ItemReceptLayoutBinding
import com.example.bookrec.model.PeceptModel

class IzbranoeAdapter(
    val context: Context,
    val list: ArrayList<PeceptModel>
):RecyclerView.Adapter<IzbranoeAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IzbranoeAdapter.CardViewHolder {
        val binding = CartAddItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IzbranoeAdapter.CardViewHolder, position: Int) {

        val listModel = list[position]
        holder.foodRecept.text = listModel.getFoodRecept()
        holder.foodOpisanie.text = listModel.getFoodOpisanie()
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }

        holder.deleteBtn.setOnClickListener{
            holder.bindItem()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

   inner class CardViewHolder(binding: CartAddItemBinding):
       RecyclerView.ViewHolder(binding.root) {

       val foodRecept = binding.homeFoodName
       val foodOpisanie = binding.homeFoodKcall
       val foodImage = binding.homeFoodImage
       val deleteBtn = binding.deleteIzbranoe


       fun bindItem(){
           if (adapterPosition != RecyclerView.NO_POSITION){
               deleteItem(adapterPosition)
           }

       }

    }

    fun deleteItem(position: Int){
       if (position in 0..list.size){
           list.removeAt(position)
           notifyDataSetChanged()
           notifyItemRangeChanged(position,list.size)
       }
    }


}