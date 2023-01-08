import java.util.ArrayList;


//Kuyruk yapısı
//Hazırda bekleyen prosesler bu kuyrukta tutulur.
public class ReadyQueue {
    private ArrayList<Process> queue;

    public ReadyQueue()
    {
        queue = new ArrayList<>();
    }

    //kuyruktan alma fonk.
    public Process dequeue()
    {
        Process p = null;
        if (!isEmpty())
        {
            p = queue.get(0);
            queue.remove(p);
        }
        return p;
    }

    public Process peek()
    {
        if(queue.isEmpty()){
            return null;
        }
        else{
            return queue.get(0);
        }
    }
    //kuyruğa ekleme fonk.
    public void enqueue(Process process)
    {
        //rasti kur radha eshte bosh
        if (queue.isEmpty()) {
            queue.add(process);
        }
        else if(!this.contain(process)){
            int i;
            for (i = 0; i < queue.size(); i++) {
                if (queue.get(i).getPriority() > process.getPriority()) {
                    queue.add(i,process);
                    break;
                }
            }
            if(i == queue.size() ){
                queue.add(process);
            }
        }
    }
    private boolean contain(Process process){
        for(Process p : queue){
            if(p.getProcessID() == process.getProcessID())
                return true;
            return false;
        }
        return false;
    }
    public int size()
    {
        return queue.size();
    }
    public Boolean isEmpty()
    {
        return (queue.size() == 0);
    }
}
