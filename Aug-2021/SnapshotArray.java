import java.util.ArrayList;
import java.util.Vector;

/**
 * @author smanjeer
 *
 *         28 Jul 2021 2:11:07 PM
 * 
 *         https://leetcode.com/problems/snapshot-array/
 * 
 */
public class SnapshotArray {

	public static void main(String[] args) {
		SnapshotArray sa= new SnapshotArray(3);
		sa.set(1, 6);
		sa.snap();
		sa.snap();
		sa.set(1, 19);
		sa.set(0, 4);
		System.out.println(sa.get(2, 1));
		System.out.println(sa.get(2, 0));
		System.out.println(sa.get(0, 1));
	}

	Vector<Vector<Integer>> array = null;
	int snapId;

	public SnapshotArray(int length) {
		this.array = new Vector<>(length);
		this.array.setSize(length);
		this.snapId = 0;
	}

	public void set(int index, int val) {

		Vector<Integer> vector = array.get(index);
		if (vector == null) {
			vector = new Vector<Integer>();
			array.set(index, vector);
		}

		if (vector.size() <= snapId) {
			vector.setSize(snapId + 1);
		}
		vector.set(snapId, val);
	}

	public int snap() {
		this.snapId++;
		return snapId - 1;
	}

	public int get(int index, int snap_id) {

		Vector<Integer> vector = array.get(index);
		if (vector == null) {
			return 0;
		}

		for (int i = Math.min(vector.size() - 1, snap_id); i >= 0; i--) {
			Integer integer = vector.get(i);
			if (integer != null) {
				return integer;
			}
		}

		return 0;
	}

}
