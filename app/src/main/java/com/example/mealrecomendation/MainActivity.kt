package com.example.mealrecomendation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Find elements by their IDs
        val img: ImageView = findViewById<ImageView>(R.id.imageView)
        val Meal: TextView = findViewById<TextView>(R.id.textView3)
        val warnMessage: TextView = findViewById<TextView>(R.id.textView4)
        val timeInput: EditText = findViewById<EditText>(R.id.editTextNumber)
        val btnSuggestMeal: Button = findViewById<Button>(R.id.button4)
        val btnReset: Button = findViewById<Button>(R.id.button7)


        btnSuggestMeal.setOnClickListener {
            //Find time of the day from the input field
            val Daytime = timeInput.text.toString()

            // check if the field is not empty
            if (Daytime.isNotEmpty()) {
                warnMessage.text = "   "
                val TheTime = Daytime.toString().toIntOrNull()
                if (TheTime != null && TheTime in 3..6) {
                    Meal.text = "Breakfast: How about some tee with toasts!!"
                } else if (TheTime in 7..10) {
                    Meal.text = "Mid-morning: some pancakes would bve good for you!"
                } else if (TheTime in 11..16) {
                    Meal.text = "lunch: We’ve got A sandwich for you"
                } else if (TheTime in 17..20) {
                    Meal.text = "Dinner: some spaghetti or pasta would be good for you"
                } else if (TheTime in 21..24) {
                    Meal.text = "Night snack: A smoothie will be perfect"
                } else {
                    Meal.text = ""
                    Meal.hint = "Please Enter a correct time!"
                }

            } else {
                warnMessage.text = "Please fill the field!!"
                Meal.text = "Rasult will be shown here"
                // Exit the click listener
                return@setOnClickListener
            }
            // Title: Kotlin MealRecommendation
            // author: Eldies Tshiseke
            // Version: 1.0
            // Available at: https://www.youtube.com/watch?v=UXGDPHNAL90
        }

        // set on click listener
        btnReset.setOnClickListener {
            // Clear the Texts
            timeInput.text.clear()
            Meal.text = ""
            Meal.hint = "Result will be shown here"
            warnMessage.text = "set your time"

        }
    }

}




