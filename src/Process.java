
public class Process {

    public java.lang.Process pBuilder; //processBuilder
    private int processID; //proses numarası
    private int priority; //öncelik
    private int arrivingTime; //varış zamanı
    private int burstTime; //çalışma zamanı

    public Process() {
        this.processID = 0;
        this.priority = 0;
        this.arrivingTime = 0;
        this.burstTime = 0;
        this.pBuilder=null;
    }
    //constructer func.
    public Process(int processID, int priority, int arrivingTime, int burstTime, java.lang.Process pB) {
        this.processID = processID;
        this.priority = priority;
        this.arrivingTime = arrivingTime;
        this.burstTime = burstTime;
        this.pBuilder=pB;
    }
    //proses  numarası al
    public int getProcessID() {
        return processID;
    }
    //proses ıd atama işlemi
    public void setProcessID(int processID) {
        this.processID = processID;
    }
    //öncelik  numarası al
    public int getPriority() {
        return priority;
    }
    //öncelik ayarla
    public void setPriority(int priority) {
        this.priority = priority;
    }
    //varış zamanı al
    public int getArrivingTime() {
        return arrivingTime;
    }
    //varış zamanı ayarla
    public void setArrivingTime(int arrivingTime) {
        this.arrivingTime = arrivingTime;
    }
    //çalışma zamanı al
    public int getBurstTime() {
        return burstTime;
    }
    //varış zamanı ayarla
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
    //proses yazdırma
    @Override
    public String toString() {
        return "{" +
                "processID = " + processID +
                ", priority = " + priority +
                ", arrivingTime = " + arrivingTime +
                ", burstTime = " + burstTime +
                '}';
    }

    public void reduceTime(int time) {
        if(burstTime >= time)
            burstTime = burstTime - time;
    }
}
