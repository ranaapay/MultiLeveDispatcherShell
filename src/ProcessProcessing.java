public class ProcessProcessing {
    private int inTime;
    private int outTime;
    private int processId;
    private int priority;

    private int burstTime;

    private int prosesStatus;

    //constructer
    public ProcessProcessing(int inTime, int outTime, int processId,int priority,int burstTime) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.processId = processId;
        this.priority=priority;
        this.burstTime=burstTime;
    }
    //sureclerin ekrana yazdırılmsı islemi
    @Override
    public String toString() {

        String result="";
        if(outTime-inTime==1 && burstTime !=1)//user proses mi
        {
            result= inTime + "  sn  " + "proses başladı" + "   (id:"+processId+ "  öncelik:"+ (priority-1) + "  kalan:"+ (burstTime+1) +")"+"\n";
            result+=(inTime+1) + "  sn  " + "proses askıda" + "    (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ (burstTime) +")"+"\n";
            return result;
        }
        else if (outTime-inTime==1 && burstTime ==1) //tek adımlı bir  proses mi
        {
            result= inTime + "  sn  " + "proses başladı" + "   (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ burstTime +")"+"\n";
            result+=(inTime+1) + "  sn  " + "proses bitti" + "     (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ (burstTime-1) +")"+"\n";
            return result;
        }
        else if (outTime-inTime==burstTime) ///Proses gerçek zamanlı mı?
        {
            result=inTime + "  sn  " + "proses başladı" + "   (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ burstTime +")"+"\n";
            for(int i=1;i<burstTime;i++)
            {
                result+=(inTime+i) + "  sn  " + "proses sürüyor" + "   (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ (burstTime-i )+")"+"\n";
            }
            result+=outTime + "  sn  " + "proses bitti" + "     (id:"+processId+ "  öncelik:"+ priority + "  kalan:"+ 0 +")"+"\n";
            return result;
        }

        return result;
    }
}
