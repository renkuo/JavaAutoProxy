package personal.renkuo.com.javaautoproxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SayHelloService sayHelloZhangsan = new ZhangsanSayHello();
        SayHelloService sayHelloLishi = new LishiSayHello();

        SayHelloProxy sayHelloProxy = new SayHelloProxy();
        sayHelloProxy.bind(sayHelloZhangsan).sayHello();
        sayHelloProxy.bind(sayHelloLishi).sayHello();

    }
}
