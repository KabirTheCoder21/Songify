package com.example.songify

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.songify.databinding.ActivitySettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SettingsActivity : AppCompatActivity() {
    lateinit var binding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Settings"
        when(MainActivity.themeIndex)
        {

            0->binding.coolPinkTheme.setBackgroundColor(Color.CYAN)
            1->binding.coolBlueTheme.setBackgroundColor(Color.CYAN)
            2-> binding.coolGreenTheme.setBackgroundColor(Color.CYAN)
            3->binding.coolPurpleTheme.setBackgroundColor(Color.CYAN)
            4->binding.coolYellowTheme.setBackgroundColor(Color.CYAN)
        }
        setTheme(MainActivity.currentThemeNav[MainActivity.themeIndex])
        binding.coolPinkTheme.setOnClickListener{
            saveTheme(0)
        }
        binding.coolBlueTheme.setOnClickListener{
            saveTheme(1)
        }
        binding.coolGreenTheme.setOnClickListener{
            saveTheme(2)
        }
        binding.coolPurpleTheme.setOnClickListener{
            saveTheme(3)
        }
        binding.coolYellowTheme.setOnClickListener{
            saveTheme(4)
        }
        binding.versionName.text = setVersionDetails()
        binding.sortBtn.setOnClickListener{
            val menuList = arrayOf("Recently Added","Song Title","File Size")
            var currentSort = MainActivity.sortOrder
            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle("Sorting")
                .setPositiveButton("Ok"){_, _ ->
                    val editor = getSharedPreferences("SORTING", MODE_PRIVATE).edit()
                    editor.putInt("sortOrder",currentSort)
                    editor.apply()
                }
                .setSingleChoiceItems(menuList,currentSort){_,which->
                    currentSort = which
                }
            val customDialog = builder.create()
            customDialog.show()

        }
    }
    @SuppressLint("CommitPrefEdits")
    private fun saveTheme(index : Int)
    {
        if(MainActivity.themeIndex != index)
        {
            val editor = getSharedPreferences("THEMES", MODE_PRIVATE).edit()
            editor.putInt("themeIndex",index)
            editor.apply()
            //Alert Dialog
            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle("Apply Theme")
                .setMessage("Do you want to apply theme? ")
                .setPositiveButton("Yes"){_, _ ->
                    exitApplication()
                }
                .setNegativeButton("No"){dialog, _ ->
                    dialog.dismiss()
                }
            val customDialog = builder.create()
            customDialog.show()
            customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED)
            customDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED)
        }
    }
    private fun setVersionDetails():String{
        return "Version Name : ${BuildConfig.VERSION_NAME}"
    }
}