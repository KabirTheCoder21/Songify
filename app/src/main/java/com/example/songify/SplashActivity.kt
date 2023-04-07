package com.example.songify

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        //If someone wants to execute multiple messages(Runnables) then he should use the Looper class which is responsible for creating a queue in the thread.
        // For example, while writing an application that downloads files from the internet, we can use Looper class to put files to be downloaded in the queue.
       // Looper Class used to run a message loop for a thread.

        //A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue.
        // When you create a new Handler it is bound to a Looper.
        // It will deliver messages and runnables to that Looper's message queue and execute them on that Looper's thread.
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Android Intent is the message that is passed between components such as activities, content providers, broadcast receivers, services etc.
                // It is generally used with startActivity() method to invoke activity, broadcast receivers etc.
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            },2000
        )
    }
}