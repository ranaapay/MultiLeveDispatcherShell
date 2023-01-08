import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder;
//Java ProcessBuilder Sınıfı
public class Builder {
    private static String outString; //çıkış <amanı
    private static String inputStrig; //giriş zamanı

    private static String waitingTime; //bekleme zamanı

    //constructer.
    public static void main(String args[]) {
        System.out.println(outString+inputStrig+waitingTime);
    }
}
