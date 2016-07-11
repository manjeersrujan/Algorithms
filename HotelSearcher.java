

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HotelSearcher {

	static class HotelDetails implements Comparable<HotelDetails> {
		public HotelDetails(int id, int matches) {
			super();
			this.id = id;
			this.matches = matches;
		}

		int id;
		int matches;

		@Override
		public int compareTo(HotelDetails o) {
			if (o != null) {
				return o.matches - this.matches;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();

			String[] words = s.split(" ");
			Set<String> set = new HashSet<String>(Arrays.asList(words));
			int numHot = Integer.parseInt(br.readLine());
			Map<Integer, HotelDetails> map = new HashMap<>();
			for (int i = 0; i < numHot; i++) {
				int id = Integer.parseInt(br.readLine());
				String[] revWords = br.readLine().split(" ");
				int count = 0;
				for (String str1 : revWords) {
					if (set.contains(str1)) {
						count++;
					}
				}

				if (map.get(id) != null) {
					HotelDetails hd = map.get(id);
					hd.matches = hd.matches + count;
				} else {
					map.put(id, new HotelDetails(id, count));
				}

			}
			List<HotelDetails> list = new ArrayList<>(map.values());
			Collections.sort(list);

			for (HotelDetails hd : list) {
				System.out.print(hd.id + " ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
