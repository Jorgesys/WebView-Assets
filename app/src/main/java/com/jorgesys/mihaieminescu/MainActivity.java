package com.jorgesys.mihaieminescu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "HTML Tricks!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.myWebView);

        String htmlData = "<!DOCTYPE html><head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> <html><head>"
               // +"<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/mystyle.css\" />"

                + "<style>body {background-color: [themeColor];}</style>"

                + "</head><body id=\"body\">"
                + "<div><P><center><img src=\"file:///android_asset/html/eminescu.jpg\" NAME=\"tablets\" align=bottom width=136 height=160 border=2></center></P></div>"
                +"<center><b>Mihai Eminescu</b> o Mihail Eminovici (15 de enero de 1850 Botosani, Moldova- 15 de junio de 1889, Bucarest, Rumanía) fue un poeta del romántico tardío. Fue poeta, prosista y periodista, calificado por la crítica literaria como la voz poética más importante de la literatura rumana.</center>"
                + "<hr><ul><li>Posiblemente es el poeta rumano más conocido a nivel mundial, siendo sus obras más conocidas Luceafărul (El lucero), Mai am un singur dor (Me queda un solo deseo), y 5 Scrisori (Cinco Cartas).</li>"
                + "<li>Era un miembro activo de la Sociedad Literaria Junimea, siendo además afiliado al Partido Conservador de Rumanía y periodista en Timpul (el periódico oficial del Partido Conservador.</li></ul>"
                + "</body></html>";


        htmlData = changeColor(htmlData);
        //Very important define baseUrl to access the resource files
        webView.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "UTF-8", null);

    }

    private String changeColor(String htmlContent){
        htmlContent = htmlContent.replace("[themeColor]", getRandomColor());
        Log.i(TAG, "htmlContent: " + htmlContent);
        return htmlContent;
    }

    public String getRandomColor(){
        Random rnd = new Random();
        int myIntColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        String rColor = String.format("#%06X", (0xFFFFFF & myIntColor));
        Log.i(TAG, "Loading random color: " + rColor);
        return rColor;
    }

}
