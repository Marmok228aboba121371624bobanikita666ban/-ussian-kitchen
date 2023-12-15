package com.example.bookrec.model

import android.widget.ImageView

class PeceptModel {

  private  var foodRecept: String = ""
  private  var foodOpisanie: String = ""
  private  var foodImage: Int? = null



    constructor()
    constructor(foodRecept:String, foodOpisanie: String, foodImage:Int?){
        this.foodRecept = foodRecept
        this.foodOpisanie = foodOpisanie
        this.foodImage = foodImage

    }


    fun getFoodImage(): Int? {
        return foodImage
    }

     fun getFoodRecept() : String {
        return foodRecept
    }

     fun getFoodOpisanie() : String {
        return foodOpisanie
    }


     fun setFoodRecept(foodRecept: String) {
        this.foodRecept = foodRecept
    }

     fun setFoodOpisanie(foodOpisanie: String) {
        this.foodOpisanie = foodOpisanie
    }

    fun setFoodImage(foodImage: Int?){
        this.foodImage = foodImage
    }


}