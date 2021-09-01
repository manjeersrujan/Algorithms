import java.util.Arrays;
import java.util.Stack;

/**
 * @author smanjeer
 *
 *         28 Jul 2021 5:05:28 AM
 * 
 *         https://leetcode.com/problems/car-fleet/
 * 
 */
public class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {

		Car[] cars = new Car[position.length];
		for (int i = 0; i < position.length; i++) {
			cars[i] = new Car(position[i], (target - position[i]) / (double)speed[i]);
		}

		Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));
		Stack<Double> stack = new Stack<>();
		for (Car car : cars) {
			if (stack.isEmpty() || car.ttl > stack.peek()) {
				stack.push(car.ttl);
			}
		}
		return stack.size();

	}

	private class Car {

		public Car(int position, double ttl) {
			super();
			this.position = position;
			this.ttl = ttl;
		}

		int position;
		double ttl;
	}
}
