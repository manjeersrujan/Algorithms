import java.util.Iterator;

/**
 * @author smanjeer
 *
 *         29 Jul 2021 12:56:20 PM
 * 
 *         https://leetcode.com/problems/peeking-iterator/
 * 
 */
public class PeekingIterator implements Iterator<Integer> {

	Integer next = null;
	Iterator<Integer> it = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.it = iterator;
		if (iterator.hasNext()) {
			next = iterator.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (next != null) {
			return next;
		} else {
			return it.next();
		}
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (next != null) {
			int curNext = this.next;
			if (it.hasNext()) {
				this.next = it.next();
			}else {
				this.next = null;
			}
			return curNext;
		} else {
			return it.next();
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

}
