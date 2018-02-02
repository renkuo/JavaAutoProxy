package personal.renkuo.com.javaautoproxy;

/**
 * Created by renkuo on 2018/2/2.
 */

public class LishiSayHello implements SayHelloService {

    @Override
    public void sayHello() {

        System.out.println("hell1 I'm" + this.getClass().getName());

    }
}
