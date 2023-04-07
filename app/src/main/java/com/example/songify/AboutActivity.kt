package com.example.songify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.songify.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentThemeNav[MainActivity.themeIndex])
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "About"
        binding.aboutText.text = aboutText()
    }
    private fun aboutText() : String{
        val x="It's so nice to see you here!" +
                "\n\nI, Kabir Seth, pursuing Bachelor of Technology in Computer science and engineering from University of Lucknow." +
                "I'm currently in 3rd year." +
                "I am enthusiast in technology. I wish to use my technical acumen to contribute to the team that works at skill and creates positive impact in our society."+
            "\n\nThis App is developed by Kabir Seth." +
                "\n\nIf you want to provide feedback, I will love to hear that."
        return x
    }
}