package cn.easyar.samples.helloar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cn.easyar.samples.helloar.R;
import okhttp3.OkHttpClient;

//import部分


public class FamousActivity extends Activity
{
//    private void butPost_OnClick(String name);
    //声明TextView对象
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.famous_person);

//获取TextView控件对象
        textView = findViewById(R.id.people_name);

        //获取启动该Activity的Intent对象
        Intent intent = getIntent();

        //获取Intent中暂存的数据
        String data1 = intent.getStringExtra("fileName");
//        String data2 = intent.getStringExtra("extra_data2");

        //将MainActivity中两个输入框的输入的内容一同在SecondActivity的TextView控件中显示出来
        textView.setText(data1);
//        butPost_OnClick(data1);
    }
    private static OkHttpClient client = new OkHttpClient();
    String data2;



    /**
     * unicode 转换成 utf-8
     * @author fanhui
     * 2007-3-15
     * @param theString
     * @return
     */
    public static String unicodeToUtf8(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
