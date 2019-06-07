import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 4 ---- 20, 4,8,2 --- 54
 * 
 * 6----1,2,5,10,35,89 --- 224
 */
public class MinimuTime {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(20);
		l.add(4);
		l.add(8);
		l.add(2);

		System.out.println(new MinimuTime().minimuTime(4, l));
		l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(5);
		l.add(10);
		l.add(35);
		l.add(89);
		System.out.println(new MinimuTime().minimuTime(6, l));

	}

	int minimuTime(int numberOfParts, List<Integer> parts) {
		if (numberOfParts <= 1) {
			return 0;
		}
		Queue<Integer> pq = new PriorityQueue<>();
		pq.addAll(parts);
		int minLength = 0;

		while (pq.size() > 2) {
			int i = pq.poll() + pq.poll();
			minLength = minLength + i;
			pq.add(i);
		}

		return pq.size() == 2 ? (minLength + pq.poll() + pq.poll()) : minLength + pq.poll();

	}

}
