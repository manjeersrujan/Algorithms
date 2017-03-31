
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Manjeer
 *
 *         Created on Mar 31, 2017
 */
public class FancySort {

	static class Expression implements Comparable<Expression> {
		String actualString;
		Double value;
		int index;
		boolean isValid = true;

		public String getActualString() {
			return actualString;
		}

		public void setActualString(String actualString) {
			this.actualString = actualString;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public boolean isValid() {
			return isValid;
		}

		public void setValid(boolean isValid) {
			this.isValid = isValid;
		}

		@Override
		public String toString() {
			return "Expression [actualString=" + actualString + ", value=" + value + ", index=" + index + ", isValid="
					+ isValid + "]";
		}

		@Override
		public int compareTo(Expression o) {
			int compare = Double.compare(o.getValue(), this.getValue());
			if (compare > 0) {
				return -1;
			} else if (compare < 0) {
				return 1;
			} else {
				if (this.index > o.getIndex()) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

	/**
	 * @param expr
	 * @return
	 */
	private static Expression evaluate(Expression expr) {
		if (expr == null) {
			return null;
		}
		String[] tokens = expr.getActualString().split(",");
		if (tokens.length <= 1) {
			expr.setValid(false);
		}

		expr.setValue(evaluate(tokens[0], tokens));

		return expr;
	}

	/**
	 * @param string
	 * @param tokens
	 * @return
	 */
	private static Double evaluate(String string, String[] tokens) {

		if (tokens[0].equals("ADD")) {
			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				value = value + Double.parseDouble(tokens[i]);
			}
			return value;
		} else if (tokens[0].equals("SUBTRACT")) {
			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				value = value - Double.parseDouble(tokens[i]);
			}
			return value;
		} else if (tokens[0].equals("MULTIPLY")) {

			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				value = value * Double.parseDouble(tokens[i]);
			}
			return value;
		} else if (tokens[0].equals("DIVIDE")) {

			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				value = value / Double.parseDouble(tokens[i]);
			}
			return value;
		} else if (tokens[0].equals("MIN")) {

			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				if (Double.compare(value, Double.parseDouble(tokens[i])) > 0) {
					value = Double.parseDouble(tokens[i]);
				}
			}
			return value;
		} else if (tokens[0].equals("MAX")) {
			Double value = Double.parseDouble(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				if (Double.compare(value, Double.parseDouble(tokens[i])) < 0) {
					value = Double.parseDouble(tokens[i]);
				}
			}
			return value;
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * @param exps
	 */
	public static void fancySort(String[] exps) {
		List<Expression> evaluatedExps = new ArrayList<>();
		System.out.println(exps[0]);
		for (int i = 0; i < exps.length; i++) {
			Expression evaluatedExp = new Expression();
			evaluatedExp.setActualString(exps[i]);
			evaluatedExp.setIndex(i);
			try {
				Expression newEvaluatedExp = evaluate(evaluatedExp);
				evaluatedExps.add(newEvaluatedExp);
			} catch (Exception e) {
				// Ignore expressions which are not in required format
			}
		}
		Collections.sort(evaluatedExps);
		for (Expression exp : evaluatedExps) {
			System.out.println(exp.getActualString());
		}

	}
}
