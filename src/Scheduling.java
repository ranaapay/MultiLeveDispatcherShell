

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scheduling {
    //Gantt
    private ArrayList<ProcessProcessing> processProcessing;
    private int currentTime;
    private int exeTime;
    private ReadyQueue readyQueue;

    public Scheduling(){
        processProcessing = new ArrayList<>();
        currentTime = 0;
        exeTime = 0;
        readyQueue = new ReadyQueue();
    }

    public ArrayList<ProcessProcessing> getSchedular(ArrayList<Process> processes) throws IOException {
        currentTime = this.getFirstArrivingTime(processes);
        int in = currentTime ,out = currentTime;
        ArrayList<Process> processes1 = this.getFirstArrivingProcesses(processes);

        for(Process process : processes1){
            readyQueue.enqueue(process);
            processes.remove(process);
        }

        ArrayList<Process> orderedByArrivingTime = this.orderProcessesByArrivingTime(processes);

        while(!readyQueue.isEmpty()){



            Process process = readyQueue.dequeue();


            byte[] buffer = new byte[65536];
            int length;

            if(orderedByArrivingTime.size() > 0)
            {
                //Handle of all arriving processes while one process has the control of CPU
                for (int i = 0; i < orderedByArrivingTime.size(); i++) {
                    Process p = orderedByArrivingTime.get(i);

                    if (p.getArrivingTime() >= process.getArrivingTime()
                            && p.getArrivingTime() < (process.getBurstTime() + currentTime)
                            && p.getPriority() >= process.getPriority()) {
                        readyQueue.enqueue(p);
                        orderedByArrivingTime.remove(p);
                        i--;
                    }
                    else if (p.getArrivingTime() >= process.getArrivingTime()
                            && p.getArrivingTime() < (process.getBurstTime() + currentTime)
                            && p.getPriority() < process.getPriority()) {
                        in = currentTime;
                        currentTime += 1;
                        process.reduceTime(currentTime - in);
                        process.setPriority(process.getPriority()+1);
                        out = currentTime;
                        readyQueue.enqueue(process);

                        while((length = process.pBuilder.getInputStream().read(buffer, 0, buffer.length)) != -1) {
                            System.out.write(buffer, 0, length);
                        }
                        processProcessing.add(new ProcessProcessing(in, out, process.getProcessID(),process.getPriority(),process.getBurstTime()));

                        readyQueue.enqueue(p);
                        orderedByArrivingTime.remove(p);
                        i--;

                        break;
                    }
                    if (i == orderedByArrivingTime.size() - 1) {
                        in = currentTime;
                        currentTime += process.getBurstTime();
                        out = currentTime;

                        processProcessing.add(new ProcessProcessing(in, out, process.getProcessID(),process.getPriority(),process.getBurstTime()));

                        if(orderedByArrivingTime.size() > 0
                                && readyQueue.isEmpty()) {
                            readyQueue.enqueue(orderedByArrivingTime.get(0));
                        }
                    }
                }
            }
            else{
                in = currentTime;
                currentTime +=1;// process.getBurstTime();
                out = currentTime;
                processProcessing.add(new ProcessProcessing(in, out, process.getProcessID(),process.getPriority(),process.getBurstTime()));
                process.setBurstTime(process.getBurstTime()-1);
                if(process.getBurstTime()!=0){readyQueue.enqueue(process); }
            }
        }
        return processProcessing;
    }

    private ArrayList<Process> orderProcessesByArrivingTime(ArrayList<Process> processes){
        ArrayList<Process> newProcesses = new ArrayList<>();
        while(processes.size() != 0) {
            Process p = this.getFirstArrivingProcess(processes);
            processes.remove(p);
            newProcesses.add(p);
        }
        return newProcesses;
    }
    private Process getFirstArrivingProcess(ArrayList<Process> processes){
        int min = Integer.MAX_VALUE;
        Process process = null;
        for(Process p : processes){
            if(p.getArrivingTime() < min){
                min = p.getArrivingTime();
                process = p;
            }
        }
        return process;
    }
    private ArrayList<Process> getFirstArrivingProcesses(ArrayList<Process> processes){
        int min = this.getFirstArrivingTime(processes);
        ArrayList<Process> processes1 = new ArrayList<>();
        for(Process p : processes){
            if(p.getArrivingTime() == min){
                processes1.add(p);
            }
        }
        return processes1;
    }
    private int getFirstArrivingTime(ArrayList<Process> processes){
        int min = Integer.MAX_VALUE;
        for(Process p : processes){
            if(p.getArrivingTime() < min){
                min = p.getArrivingTime();
            }
        }
        return min;
    }

}