package com.example.bookrec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookrec.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodImage = intent.getIntExtra("foodImage",0)
        val foodName = intent.getStringExtra("foodRecept")

        binding.menuFoodImage.setImageResource(foodImage)
        binding.menuFoodOpisanie.text = foodName
        binding.backHome.setOnClickListener {
            finish()
        }
    }
}