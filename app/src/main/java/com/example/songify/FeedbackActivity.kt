package com.example.songify

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.songify.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {

    lateinit var binding: ActivityFeedbackBinding

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentThemeNav[MainActivity.themeIndex])
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Feedback"
        binding.sendFA.setOnClickListener {
            val email = binding.emailFA.text.toString().trim()
            val subject = binding.topicFA.text.toString().trim()
            val message = binding.feedbackMsgFA.text.toString().trim()

            if (!email.isEmpty() && !subject.toString().isEmpty()
                && !message.isEmpty()) {
                sendEmail(email,subject,message)
            } else {
                Toast.makeText(this, "Please fill all the fields",
                    Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("IntentReset")
    private fun sendEmail(email: String, subject: String, message: String) {

        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data= Uri.parse("mailto:")
        mIntent.type="message/rfc822"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
        mIntent.putExtra(Intent.EXTRA_TEXT,message)

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }catch (e : Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}