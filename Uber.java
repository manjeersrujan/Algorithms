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

		if (tasks == null || tasks.length == 0) {
			return 0;
		} else if (tasks.length == 1) {
			return 1;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		Map<Integer, Integer> m = new HashMap<>();
		int i = 0;
		int time = 0;
		while (i < tasks.length) {
			if (q.isEmpty()) {
				time++;
				q.add(tasks[i]);
				m.put(tasks[i], 1);
				i++;
			} else {
				if (m.get(tasks[i]) == null || m.get(tasks[i]) == 0) {
					q.add(tasks[i]);
					m.put(tasks[i], 1);
					time++;
					i++;
				} else {
					q.add(-1); // pause
					time++;
				}
			}

			if (q.size() > cd) {
				Integer poll = q.poll();
				if (m.get(poll) != null) {
					int n = m.get(poll);
					if (n > 0) {
						m.put(poll, n - 1);
					}
				}
			}
		}
		return time;
	}
}