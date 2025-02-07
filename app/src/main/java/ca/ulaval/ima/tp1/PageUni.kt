package ca.ulaval.ima.tp1

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageUni : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_uni)

        val extrasUrl = intent.extras
        val urlMap = extrasUrl?.getString("url")
        val webViewMapUlaval = findViewById<WebView>(R.id.webViewMap)
        webViewMapUlaval.loadUrl(urlMap.toString())
        webViewMapUlaval.settings.javaScriptEnabled = true


        val boutonFermer = findViewById<Button>(R.id.boutonFermer)
        boutonFermer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}