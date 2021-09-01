import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author smanjeer
 *
 *         18 Aug 2021 1:04:12 AM
 * 
 *         https://leetcode.com/problems/single-threaded-cpu/
 * 
 */
public class SingleThreadedCPU {
	public int[] getOrder(int[][] tasks) {
		int[] res = new int[tasks.length];
		List<Task> sortedTasks = new ArrayList<>();
		for (int i = 0; i < tasks.length; i++) {
			sortedTasks.add(new Task(i, tasks[i][0], tasks[i][1]));
		}
		Collections.sort(sortedTasks, (a, b) -> a.et - b.et);
		Queue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {

			@Override
			public int compare(Task t1, Task t2) {
				if (t1.pt != t2.pt) {
					return t1.pt - t2.pt;
				} else {
					return t1.index - t2.index;
				}
			}

		});
		int ct = 0;
		int i = 0;
		while (!sortedTasks.isEmpty()) {
			while (!sortedTasks.isEmpty() && ct >= sortedTasks.get(0).et) {
				pq.add(sortedTasks.remove(0));
			}

			if (pq.isEmpty()) {
				ct = sortedTasks.get(0).et;
			}
			
			while (!sortedTasks.isEmpty() && ct >= sortedTasks.get(0).et) {
				pq.add(sortedTasks.remove(0));
			}

			Task curTask = pq.poll();
			res[i++] = curTask.index;
			ct += curTask.pt;
		}

		while (!pq.isEmpty()) {
			res[i++] = pq.poll().index;
		}

		return res;

	}

	class Task {
		public Task(int index, int et, int pt) {
			this.index = index;
			this.et = et;
			this.pt = pt;
		}

		int index;
		int et;
		int pt;
	}

}
