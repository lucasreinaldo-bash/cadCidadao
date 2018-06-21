package desenvolvimento.vostore.appnaco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class github extends AppCompatActivity {
WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        mWebView =  findViewById(R.id.webView);
        mWebView.setWebViewClient(new MyAppWebViewClient());
        WebSettings webSettings = mWebView.getSettings ();
        webSettings.setJavaScriptEnabled( true );

        // String pdf = "https://www.infoenem.com.br/wp-content/uploads/2011/10/CAD_ENEM-2015_DIA-1_02_AMARELO.pdf";
        mWebView.loadUrl("https://github.com/neguives" );
    }
    public void onBackPressed() {

        Intent intent = new Intent(github.this, Sobre.class);
        startActivity(intent);
        finish();

    }
}
