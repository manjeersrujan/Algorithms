import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author smanjeer
 *
 *         21 Aug 2021 3:26:14 PM
 * 
 *         https://leetcode.com/problems/process-tasks-using-servers/
 * 
 */
public class ProcessTasksUsingServers {

	public int[] assignTasks(int[] servers, int[] tasks) {

		int[] ans = new int[tasks.length];

		PriorityQueue<Server> freePq = new PriorityQueue<>(new Comparator<Server>() {

			@Override
			public int compare(Server o1, Server o2) {
				if (o1.w != o2.w) {
					return o1.w - o2.w;
				} else {
					return o1.i - o2.i;
				}
			}
		});
		PriorityQueue<Server> busyPq = new PriorityQueue<>(new Comparator<Server>() {

			@Override
			public int compare(Server o1, Server o2) {
				if(o1.endTime != o2.endTime) {
					return  o1.endTime - o2.endTime;
				}
				if (o1.w != o2.w) {
					return o1.w - o2.w;
				} else {
					return o1.i - o2.i;
				}
			}
		});

		for (int i = 0; i < servers.length; i++) {
			freePq.offer(new Server(i, servers[i]));
		}

		for (int i = 0; i < tasks.length; i++) {

			while (!busyPq.isEmpty() && busyPq.peek().endTime <= i) {
				freePq.offer(busyPq.poll());
			}

			Server cur = null;
			if (freePq.isEmpty()) {
				cur = busyPq.poll();
				cur.endTime = cur.endTime + tasks[i];
			} else {
				cur = freePq.poll();
				cur.endTime = i + tasks[i];
			}
			

			ans[i] = cur.i;
			busyPq.offer(cur);

		}

		return ans;
	}

	class Server {
		public Server(int i, int w) {
			super();
			this.w = w;
			this.i = i;
		}

		int w;
		int i;
		int endTime = 0;

	}

}
