/**
 * @author Manjeer on Jul 12, 2016
 *
 */
public class CarParkingPriceCalculator {

	public int solution(String E, String L) {
		String[] start = E.split(":");
		String[] end = L.split(":");

		int sHour = 0;
		int sMin = 0;
		int eHour = 0;
		int eMin = 0;

		if (start.length == 2) {
			sHour = Integer.parseInt(start[0]);
			sMin = Integer.parseInt(start[1]);
		} else {
			return -1;
		}

		if (end.length == 2) {
			eHour = Integer.parseInt(end[0]);
			eMin = Integer.parseInt(end[1]);
		} else {
			return -1;
		}

		int hours = 0;

		if (sHour == eHour && eMin >= sMin) {
			return 5;
		} else if (sHour < eHour && eMin > sMin) {
			hours = eHour - sHour + 1;
		} else if (sHour < eHour && eMin <= sMin) {
			hours = eHour - sHour;
		}

		int total = 2;

		if (hours > 0) {
			total = total + 3;
			hours--;
		}

		while (hours > 0) {
			total = total + 4;
			hours--;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(new CarParkingPriceCalculator().solution("10:35", "13:21"));
	}

}
