import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeFiles {

	public static void main(String[] args) {
		List<Integer> files = new ArrayList<>();
		files.add(23);
		files.add(55);
		files.add(102);
		files.add(3);

		System.out.println(new MergeFiles().minimumTime(4, files));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	int minimumTime(int numOfSubFiles, List<Integer> files) {

		if (files == null || files.size() <= 1) {
			return 0;
		}

		Queue<Integer> que = new PriorityQueue<>();
		que.addAll(files);

		int totalTime = 0;
		while (que.size() > 2) {
			int size = que.poll() + que.poll();
			totalTime = totalTime + size;
			que.add(size);
		}

		return totalTime + que.poll() + que.poll();

	}
}
