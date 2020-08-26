package id.ac.its.ppid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myitsinfo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setSupportActionBar(findViewById(R.id.toolbar))

        // Kode Webview Start
        val myWebView : WebView = findViewById(R.id.webKu)

        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    url: String?
            ): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        myWebView.loadUrl("https://www.its.ac.id/ppid/")
        myWebView.settings.javaScriptEnabled=true
        myWebView.settings.allowContentAccess=true
        myWebView.settings.domStorageEnabled=true
        myWebView.settings.useWideViewPort=true

        // Kode WebView End
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        val myWebView : WebView = findViewById(R.id.webKu)

        // if your myWebView can go back it will go back
        if (myWebView.canGoBack())
            myWebView.goBack()
        // if your myWebView cannot go back it will exit the application
        else
            super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}