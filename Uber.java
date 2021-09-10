import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Given a list of tasks and a cooldown to be respected for the same type of task, calculate how long it would take to execute the entire list of tasks

Ex 1:
tasks = [5, 5, 3, 5, 3]
cooldown = 2
execution = [5, _, _, 5, 3, _, 5, 3]
output = 8  



*/

public class Uber {
	public static void main(String args[]) throws Exception {
		int[] tasks = { 5, 5, 3, 5, 3 };
		int cd = 2;
		System.out.println(new Uber().getRunTime(tasks, cd));
	}

	public int getRunTime(int[] tasks, int cd) {

		if(tasks == null || tasks.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        int time = 0;
        while(i< tasks.length){
            if(!map.containsKey(tasks[i]) ){
                time++;
                map.put(tasks[i], time);
                i++;
            } else {
                int index = map.get(tasks[i]);
                if(time - index >= cd){
                    time++;
                    map.put(tasks[i], time);
                    i++;
                } else{
                    time  = time + (cd - (time-index));
                    time++;
                    map.put(tasks[i], time);
                    i++;
                }
            }
        }
        
        return time;
	}
}
