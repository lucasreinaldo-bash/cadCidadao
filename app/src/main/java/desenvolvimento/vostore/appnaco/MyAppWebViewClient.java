package desenvolvimento.vostore.appnaco;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by lucas on 18/10/2017.
 */
public class MyAppWebViewClient extends WebViewClient {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        String url = request.getUrl().toString();
        if(Uri.parse(url).getHost().endsWith("https://www.facebook.com/lucas.s.reinaldo/")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}