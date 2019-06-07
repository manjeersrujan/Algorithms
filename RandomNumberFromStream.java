/*
 * This is your coding interview problem for today.
This problem was asked by Facebook.
Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */
public class RandomNumberFromStream {

	public long getRandomNumberFromStream(int streamSize) {
		long count = 0;
		long curRandom = 0;
		while (count < streamSize) {
			long rand = getRandom(count);
			if(rand == 0) {
				curRandom = getNext();
			}
			count++;
		}
		return curRandom;
	}

	private long getNext() {
		return getRandom(Long.MAX_VALUE);
	}

	private long getRandom(long maxInt) {
		return (long) Math.floor(Math.random() * maxInt);
	}
}
