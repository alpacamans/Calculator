package dino.developer.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import dino.developer.calculator.R;

public class MainActivity extends AppCompatActivity {

    int[] number = new int[100];
    int point=0;
    int num = 0;
    int searchE = 0;
    TextView inputText;
    TextView resultText;
    String input_Text = "";
    String result_Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        Button one_btn = findViewById(R.id.oneBtn);
        Button two_btn = findViewById(R.id.twoBtn);
        Button three_btn = findViewById(R.id.three);
        Button four_btn = findViewById(R.id.four);
        Button five_btn = findViewById(R.id.five);
        Button six_btn = findViewById(R.id.six);
        Button seven_btn = findViewById(R.id.seven);
        Button eight_btn = findViewById(R.id.eight);
        Button nine_btn = findViewById(R.id.nine);
        Button zero_btn = findViewById(R.id.zero);
        Button zerozero_btn = findViewById(R.id.zerozero);
        Button result_btn = findViewById(R.id.result);
        Button era_btn = findViewById(R.id.era);
        Button sum_btn = findViewById(R.id.sum);
        Button sub_btn = findViewById(R.id.sub);
        Button clear_btn = findViewById(R.id.clear);
        Button mul_btn = findViewById(R.id.mul);
        Button div_btn = findViewById(R.id.div);
        Button point_btn = findViewById(R.id.point);
        inputText = findViewById(R.id.input_text);
        resultText = findViewById(R.id.result_text);
        inputText.setText("");
        resultText.setText("");
        one_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("onebtn","click");
                        addNumber(1);
                    }
                }
        );
        two_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("twoBtn","click");
                        addNumber(2);
                    }
                }
        );
        three_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("threeBtn","click");
                        addNumber(3);
                    }
                }
        );
        four_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("fourBtn","click");
                        addNumber(4);
                    }
                }
        );
        five_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("fiveBtn","click");
                        addNumber(5);
                    }
                }
        );
        six_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("sixBtn","click");
                        addNumber(6);
                    }
                }
        );
        seven_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("sevenBtn","click");
                        addNumber(7);
                    }
                }
        );
        eight_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("eightBtn","click");
                        addNumber(8);
                    }
                }
        );
        nine_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("nineBtn","click");
                        addNumber(9);
                    }
                }
        );
        zero_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("zeroBtn","click");
                        addNumber(0);
                    }
                }
        );
        zerozero_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("zerozeroBtn","click");
                        addNumber(0);
                        addNumber(0);

                    }
                }
        );

        sum_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("sum","click");

                        sumNumber();
                    }
                }
        );
        sub_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("sub","click");

                        subNumber();
                    }
                }
        );
        mul_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("mul","click");

                        mulNumber();
                    }
                }
        );
        div_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("div","click");

                        divNumber();
                    }
                }
        );
        point_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        try {
                            String last = input_Text.substring(input_Text.length() - 1);
                            Log.d("point", "click");
                            if (!(last.equals("") || last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*"))) {
                                pointNumber();
                            } else {
                                input_Text = input_Text.concat("0");
                                pointNumber();
                            }
                        }catch (Exception e){
                            Log.d("포인트","없음");
                            input_Text = input_Text.concat("0");
                            pointNumber();
                        }
                    }
                }
        );
        clear_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("clear","click");
                        clearNumber();
                    }
                }
        );
        era_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("era","click");
                        input_Text = eraNumber(input_Text);
                        inputText.setText(input_Text);

                    }
                }
        );
        result_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Log.d("result","click");
                        result();
                    }
                }
        );

    }
    public void addNumber(int i){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (i == 0 && last.equals("") && (last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*"))) {
                return;
            }
        }catch (Exception e){
            Log.d("addNumber","에러뜸요");
        }
        input_Text = input_Text.concat(Integer.toString(i));
        inputText.setText(input_Text);

        return;
    }
    public String eraNumber(String Str){
        try {
            String last = Str.substring(Str.length() - 1);
            if (Str != null && Str.length() > 0 && !(last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*"))) {
                if(last.equals(".")){
                    if(point>0) {
                        point--;
                    }
                }
                Str = Str.substring(0, Str.length() - 1);

            }
        }catch (Exception e){
            Log.d("지우기","에러뜸");
        }
        return Str;
    }

    public void sumNumber(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (!(last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals(""))) {
                if(last.equals(".")){
                    input_Text = input_Text.concat("0");
                }
                input_Text = input_Text.concat("+");
                if(point==1) {
                    point--;
                }

            }
        }catch (Exception e){
            Log.d("썸","에러");
        }
        inputText.setText(input_Text);
        return;
    }
    public void subNumber(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (!(last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals(""))) {
                if(last.equals(".")){
                    input_Text = input_Text.concat("0");
                }
                input_Text = input_Text.concat("-");
                if(point==1) {
                    point--;
                }


            }
        }catch (Exception e){
            Log.d("빼기","에러");
        }
        inputText.setText(input_Text);
        return;
    }
    public void mulNumber(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (!(last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals(""))) {
                if(last.equals(".")){
                    input_Text = input_Text.concat("0");
                }
                input_Text = input_Text.concat("*");
                if(point==1) {
                    point--;
                }

            }
        }catch (Exception e){
            Log.d("곱하기","에러");
        }
        inputText.setText(input_Text);
        return;
    }
    public void divNumber(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (!(last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals(""))) {
                if(last.equals(".")){
                    input_Text = input_Text.concat("0");
                }
                input_Text = input_Text.concat("/");
                if(point==1) {
                    point--;
                }

            }
        }catch (Exception e){
            Log.d("나누기","에러");
        }
        inputText.setText(input_Text);
        return;
    }
    public void pointNumber(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if (point==0) {
                input_Text = input_Text.concat(".");
                Log.d("포인트와 넘버","포"+point+"넘"+num);
                point++;
            }
        }catch (Exception e){
            Log.d("포인트","에러");
        }
        inputText.setText(input_Text);
        return;
    }




    public void clearNumber(){
        input_Text="";
        inputText.setText(input_Text);
        result_Text="";
        resultText.setText(result_Text);

    }
    public void searchE(){
        Log.d("서치","됐음");
        Log.d("서치",""+result_Text);
        int E=0;
        try {
            E = Integer.parseInt(result_Text.substring(result_Text.lastIndexOf("E") + 1));
        } catch(Exception e){
            Log.d("서치","에러");
        }
        if(result_Text.contains("E")&&E<=15) {
            searchE = 1;
            result_Text = result_Text.replace(".","");
            result_Text = result_Text.substring(0,result_Text.lastIndexOf("E"));
            for(int i = result_Text.length();i<=E;i++){
                result_Text= result_Text.concat("0");
            }
            Log.d("점삭제","됐음"+E);
        }else{
            searchE = 0;
            Log.d("점삭제","안됌");

        }

    }


    public void result(){
        try {
            String last = input_Text.substring(input_Text.length() - 1);
            if ((last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals(""))) {
                input_Text = input_Text + "0";
            }
        }catch (Exception e){
            Log.d("결과","숫자부족");
        }
        if(input_Text.equals("")){
            inputText.setText("");
            resultText.setText("");
            return;
        }
        Log.d("포인트와 인풋",""+point+eval.eval(input_Text));
        if(point==0&&10000000>eval.eval(input_Text)){
            result_Text=Double.toString(eval.eval(input_Text));
            result_Text=eraNumber(result_Text);
            result_Text=eraNumber(result_Text);
            searchE();
            resultText.setText(result_Text);
            input_Text="";
        }else {
            result_Text=Double.toString(eval.eval(input_Text));
            searchE();
            resultText.setText(result_Text);
            input_Text="";
        }
    }

}