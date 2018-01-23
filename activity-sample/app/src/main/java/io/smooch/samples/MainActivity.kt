package io.smooch.samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.smooch.core.Settings
import io.smooch.core.Smooch
import io.smooch.ui.ConversationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButton.setOnClickListener { initSmooch() }

        openConversationButton.setOnClickListener({
            ConversationActivity.show(this)
        })
    }

    private fun initSmooch() {
        Smooch.init(application, Settings(appIdInput.text.toString()), { response ->
            if (response.error == null) {
                Toast.makeText(this, "Connected to Smooch! \\o/", Toast.LENGTH_LONG)
                        .show()
                openConversationButton.isEnabled = true
            } else {
                Toast.makeText(this, "Error connecting to Smooch :(", Toast.LENGTH_LONG)
                        .show()
                openConversationButton.isEnabled = false
            }
        })
    }
}
