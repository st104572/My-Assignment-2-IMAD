package com.example.myassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the button and text view
        val btnFeed = findViewById<Button>(R.id.btn_feed)
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val btnHappy = findViewById<Button>(R.id.btn_happy)
        val txtHunger = findViewById<EditText>(R.id.txt_hungry)
        val txtClean = findViewById<EditText>(R.id.txt_clean_value)
        val txtHappy = findViewById<EditText>(R.id.txt_happy)
        val petImage = findViewById<ImageView>(R.id.pet_image)

        // Set the initial text values
        txtHunger.setText(petHunger.toString())
        txtClean. setText(petCleanliness).toString()
        txtHappy.setText(petHealth.toString())

        // Handle button clicks
        btnFeed.setOnClickListener {
            petHunger -= 10
            petHealth += 10
            petHunger += 5
            txtHunger.setText(petHunger.toString())
            animateImageChange(petImage, R.drawable.eating_dog)
        }

        btnClean.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            txtClean.setText(petCleanliness.toString())
            animateImageChange(petImage, R.drawable.eating_dog)
        }

        btnClean.setOnClickListener {
            petHunger += 10
            txtHappy.setText(petHealth.toString())
            animateImageChange(petImage, R.drawable.happy_dog)
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter =true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}

