import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.SystemColor.*;

public class Main {
    public static void main(String[] args) throws IOException {
            ReadBuffer in = new ReadBuffer(); //proses çıktıları için buffer.
            //dosyadan processlerin okunması ve gerekli kuyruklara yerleştirilmesi.
            ArrayList<Process> processes = in.getProcesses("C:\\Users\\durda\\IdeaProjects\\untitled\\src\\veriler.txt");
            //proseslerin yönetilmesi.
            ArrayList<ProcessProcessing> gantt = new Scheduling().getSchedular(processes);
            //sonuc yazdır.
            System.out.print(gantt.toString().replace(", ",""));
    }
}