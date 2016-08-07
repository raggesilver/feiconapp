package com.example.ctpsarah.feicon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int currentStep = 0;

    int knowsEpigenetics;
    int questionAnsw;
    int isIFTM;
    int type;

    int lastClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_main);

        WebViewClient mWebViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //test("App", "Gostou do app?", view);
                if(view.getUrl().toLowerCase().endsWith("quizz")){

                    startQuiz();
                } else if(view.getUrl().toLowerCase().endsWith("app")){
                    Intent app = new Intent(MainActivity.this.getApplicationContext(), QuizActivity.class);
                    startActivity(app);
                    finish();
                }
            }
        };

        String appKey = "123456789";

        WebView _web = (WebView) findViewById(R.id.webView);
        _web.setWebViewClient(mWebViewClient);
        _web.loadUrl("http://172.16.21.203/app_server/index.php?key=" + appKey);

        Button btn = (Button) findViewById(R.id.yesBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentStep == 0){
                    currentStep = 1;
                    knowsEpigenetics = 1;
                }
                lastClicked = 1;
                advance();
            }
        });

        Button btn2 = (Button) findViewById(R.id.noBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentStep == 0){
                    knowsEpigenetics = 0;
                }
                if(currentStep == 3){
                    currentStep++;
                }
                lastClicked = 0;
                advance();
            }
        });

    }

    private void startQuiz() {

        CheckBox check1 = (CheckBox) findViewById(R.id.questionBtn1);
        CheckBox check2 = (CheckBox) findViewById(R.id.questionBtn2);
        CheckBox check3 = (CheckBox) findViewById(R.id.questionBtn3);

        check1.setVisibility(View.INVISIBLE);
        check2.setVisibility(View.INVISIBLE);
        check3.setVisibility(View.INVISIBLE);

        RelativeLayout quizBar = (RelativeLayout) findViewById(R.id.quizBar);
        RelativeLayout bottomBar = (RelativeLayout) findViewById(R.id.bottomBar);

        quizBar.setVisibility(View.VISIBLE);

        bottomBar.setVisibility(View.VISIBLE);

        Button noBtn = (Button) findViewById(R.id.noBtn);
        noBtn.setText("Não");

        Button yesBtn = (Button) findViewById(R.id.yesBtn);
        yesBtn.setVisibility(View.VISIBLE);
        yesBtn.setText("Sim");

        TextView txt = (TextView) findViewById(R.id.label);
        txt.setText("Você sabe o que é epigenética?");
    }

    public void quizSecond() {
        RelativeLayout quizBar = (RelativeLayout) findViewById(R.id.quizBar);
        quizBar.setVisibility(View.VISIBLE);

        CheckBox check1 = (CheckBox) findViewById(R.id.questionBtn1);
        CheckBox check2 = (CheckBox) findViewById(R.id.questionBtn2);
        CheckBox check3 = (CheckBox) findViewById(R.id.questionBtn3);

        check1.setVisibility(View.INVISIBLE);
        check2.setVisibility(View.INVISIBLE);
        check3.setVisibility(View.INVISIBLE);

        TextView txt = (TextView) findViewById(R.id.label);
        txt.setText("Epigenética é a comprovação científica da frase: \"você é o que você come\"");

        Button yesBtn = (Button) findViewById(R.id.yesBtn);
        yesBtn.setText("Próximo");

        Button noBtn = (Button) findViewById(R.id.noBtn);
        noBtn.setVisibility(View.INVISIBLE);

    }

    public void quizThird() {
        CheckBox check1 = (CheckBox) findViewById(R.id.questionBtn1);
        CheckBox check2 = (CheckBox) findViewById(R.id.questionBtn2);
        CheckBox check3 = (CheckBox) findViewById(R.id.questionBtn3);

        check1.setVisibility(View.VISIBLE);
        check2.setVisibility(View.VISIBLE);
        check3.setVisibility(View.VISIBLE);

        check1.setText("Alternativa 1");
        check2.setText("Alternativa 2");
        check3.setText("Alternativa 3");

        TextView txt = (TextView) findViewById(R.id.label);
        txt.setText("Marque a opção que corresponde a Epigenética.");

        Button yesBtn = (Button) findViewById(R.id.yesBtn);
        yesBtn.setText("Próximo");

        Button noBtn = (Button) findViewById(R.id.noBtn);
        noBtn.setVisibility(View.INVISIBLE);

    }

    public void quizLast(boolean ans) {
        CheckBox check1 = (CheckBox) findViewById(R.id.questionBtn1);
        CheckBox check2 = (CheckBox) findViewById(R.id.questionBtn2);
        CheckBox check3 = (CheckBox) findViewById(R.id.questionBtn3);

        RelativeLayout quizBar = (RelativeLayout) findViewById(R.id.quizBar);
        RelativeLayout bottomBar = (RelativeLayout) findViewById(R.id.bottomBar);

        quizBar.setVisibility(View.VISIBLE);

        bottomBar.setVisibility(View.VISIBLE);

        Button noBtn = (Button) findViewById(R.id.noBtn);
        noBtn.setVisibility(View.VISIBLE);
        noBtn.setText("Não");

        Button yesBtn = (Button) findViewById(R.id.yesBtn);
        yesBtn.setVisibility(View.VISIBLE);
        yesBtn.setText("Sim");

        TextView txt = (TextView) findViewById(R.id.label);
        txt.setText("Você é do IFTM?");

        if(ans){
            check1.setVisibility(View.VISIBLE);
            check2.setVisibility(View.VISIBLE);
            check3.setVisibility(View.VISIBLE);

            check1.setText("Aluno Médio");
            check2.setText("Aluno Superior");
            check3.setText("Servidor");
        } else {
            check1.setVisibility(View.INVISIBLE);
            check2.setVisibility(View.INVISIBLE);
            check3.setVisibility(View.INVISIBLE);
        }
    }

    public void thankPage() {
        RelativeLayout quizBar = (RelativeLayout) findViewById(R.id.quizBar);
        quizBar.setVisibility(View.VISIBLE);

        CheckBox check1 = (CheckBox) findViewById(R.id.questionBtn1);
        CheckBox check2 = (CheckBox) findViewById(R.id.questionBtn2);
        CheckBox check3 = (CheckBox) findViewById(R.id.questionBtn3);

        check1.setVisibility(View.INVISIBLE);
        check2.setVisibility(View.INVISIBLE);
        check3.setVisibility(View.INVISIBLE);

        TextView txt = (TextView) findViewById(R.id.label);
        txt.setText("Obrigado por cooperar com nossa pesquisa.");

        Button yesBtn = (Button) findViewById(R.id.yesBtn);
        yesBtn.setText("Próximo");

        Button noBtn = (Button) findViewById(R.id.noBtn);
        noBtn.setVisibility(View.INVISIBLE);
    }

    public void advance() {
        Button btn = (Button) findViewById(R.id.yesBtn);

        switch (currentStep) {
            case 0: btn.setBackgroundColor(Color.BLUE);
                    quizSecond();
                    currentStep++;
                    break;
            case 1: btn.setBackgroundColor(Color.GREEN);
                    quizThird();
                    currentStep++;
                    break;
            case 2: btn.setBackgroundColor(Color.RED);
                    quizLast(false);
                    currentStep++;
                    break;
            case 3: btn.setBackgroundColor(Color.MAGENTA);
                    quizLast(true);
                    isIFTM = 1;
                    currentStep++;
                    break;
            default: thankPage();
        }
    }

}