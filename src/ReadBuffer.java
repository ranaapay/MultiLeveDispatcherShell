import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Proseslerin dosyadan okunması
public class ReadBuffer {
    private ArrayList<Process> processes; //proses listesi
    private Scanner input; //okuyucu

    private ProcessBuilder processBuilder; //proses builder
    //constructer
    public ReadBuffer(){
        processes = new ArrayList<>();
        input = new Scanner(System.in);
    }
    //proseslerin okunduğu func.
    public ArrayList<Process> getProcesses(String filePath ) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath)); //okuyucu sınıfı olusturulması
        String line;
        int countOfLine=0; //satır sayısı
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", "); //virgüller ile ayırma islemi
            int arrivalTime = Integer.parseInt(parts[0]); //varış zamanı
            int priority = Integer.parseInt(parts[1]); //öncelik ve
            int duration = Integer.parseInt(parts[2]);//calışma zamanı verilerinin alınmsı
            //prosesin execlenmesi
            java.lang.Process processBuilder = Runtime.getRuntime().exec("java out/production/Multilevel-Dispatcher-Shell/Builder");
            processes.add(new Process(countOfLine, priority, arrivalTime, duration,processBuilder)); //kuyruga eklenmesi
            countOfLine+=1;
        }
        return processes; //listeyi dönddür.
    }

}
