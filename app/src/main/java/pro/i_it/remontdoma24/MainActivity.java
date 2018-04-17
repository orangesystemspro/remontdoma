package pro.i_it.remontdoma24;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    private static final int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View logo = findViewById(R.id.logo);
        final WebView web = findViewById(R.id.web);
        web.setVisibility(GONE);
        web.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.setVisibility(GONE);
                web.setVisibility(VISIBLE);
                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl("https://remontdoma24.ru/");
            }
        }, DELAY);
    }
}
