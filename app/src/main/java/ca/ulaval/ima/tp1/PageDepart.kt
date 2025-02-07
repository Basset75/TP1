package ca.ulaval.ima.tp1

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PageDepart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_depart)

        val extrasUrl = intent.extras
        val urlMap = extrasUrl?.getString("url")
        val webViewDepUlaval = findViewById<WebView>(R.id.webViewDep)
        webViewDepUlaval.loadUrl(urlMap.toString())
        webViewDepUlaval.settings.javaScriptEnabled = true

    }
}