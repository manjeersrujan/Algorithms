import java.util.regex.Pattern;

/**
 * @author yeddulamanjeersrujan
 *
 *         May 31, 2019
 * 
 *         1) This class is not thread safe
 * 
 *         2) Works only for code, country.
 * 
 *         3) We can add more fields in AirPort class and return Airport(It
 *         doesn't have public setters) object instead of String to handle more
 *         fields
 * 
 *         4) Code should be as length 3 and only alphabets
 * 
 *         5) Didn't add delete method
 * 
 *         6) Validations are simple. If we need more validations and the code
 *         should be more abstracted
 * 
 * 
 *
 */
public class SimpleLocalCacheUsingTrie {

	private Trie cache = new Trie(null);
	private Pattern airportCodePattern = Pattern.compile("[a-zA-Z]");
	private static SimpleLocalCacheUsingTrie instance = null;

	/**
	 * 
	 */
	private SimpleLocalCacheUsingTrie() {
		super();
	}

	/**
	 * @author yeddulamanjeersrujan
	 *
	 *         May 31, 2019
	 *
	 */
	private class Airport {
		public Airport(String code, String country) {
			super();
			this.code = code;
			this.country = country;
		}

		public String getCode() {
			return code;
		}

		public String getCountry() {
			return country;
		}

		private String code;
		private String country;
	}

	/**
	 * @author yeddulamanjeersrujan
	 *
	 *         May 31, 2019
	 * 
	 *         The trie node
	 *
	 */
	private class Trie {
		public Trie(Airport ap) {
			super();
			this.ch = new Trie[26];
			this.ap = ap;
		}

		Trie[] ch = null;
		Airport ap;
	}

	/**
	 * @return
	 * 
	 * 		Abstract method to get singleton object
	 */
	public static SimpleLocalCacheUsingTrie getInstance() {

		if (instance == null) {
			synchronized (SimpleLocalCacheUsingTrie.class) {
				if (instance == null) {
					instance = new SimpleLocalCacheUsingTrie();
				}
			}
		}
		return instance;
	}

	/**
	 * @param code
	 * @param country
	 */
	protected void insertAirport(String code, String country) {
		if (code == null || code.length() != 3 || !airportCodePattern.matcher(code).find()) {
			throw new IllegalArgumentException("Code should be non-null, of length 3 and only alphabets");
		}

		int i = 0;
		Trie cur = cache;
		code = code.toUpperCase();
		while (i < code.length()) {
			if (cur.ch[code.charAt(i) - 'A'] == null) {
				cur.ch[code.charAt(i) - 'A'] = new Trie(null);
			}
			cur = cur.ch[code.charAt(i) - 'A'];
			i++;
		}
		cur.ap = new Airport(code, country);
	}

	/**
	 * @param code
	 * @return
	 */
	public String getCountry(String code) {
		if (code == null || code.length() != 3 || !airportCodePattern.matcher(code).find()) {
			throw new IllegalArgumentException("Code should be non-null, of length 3 and only alphabets");
		}

		int i = 0;
		Trie cur = cache;
		code = code.toUpperCase();
		while (i < code.length()) {
			if (cur.ch[code.charAt(i) - 'A'] == null) {
				return null;
			}
			cur = cur.ch[code.charAt(i) - 'A'];
			i++;
		}
		return (cur.ap != null && cur.ap.getCode() != null && cur.ap.getCode().equals(code)) ? cur.ap.getCountry()
				: null;
	}

	public static void main(String[] args) {

		SimpleLocalCacheUsingTrie sc = SimpleLocalCacheUsingTrie.getInstance();
		sc.insertAirport("abc", "abcCountry");
		sc.insertAirport("bcd", "bcdCountry");
		sc.insertAirport("xyz", "xyzCountry");

		System.out.println(sc.getCountry("abc"));
		System.out.println(sc.getCountry("bcd"));
		System.out.println(sc.getCountry("xyz"));
		System.out.println(sc.getCountry("xyc"));
		System.out.println(sc.getCountry("pqr"));

	}

}
