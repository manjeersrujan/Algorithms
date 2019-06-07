
public class SerDeserBinaryTre {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(13);
		root.right.left.left = new Node(12);

		root.right.right = new Node(17);
		root.right.right.right = new Node(25);
		SerDeserBinaryTre serDeserBinaryTre = new SerDeserBinaryTre();
		String serialize = serDeserBinaryTre.serialize(root);
		System.out.println(serDeserBinaryTre.serialize(serDeserBinaryTre.deserialize(serialize)));
	}

	static class Node {
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(int data) {
			super();
			this.data = data;
		}

		int data;
		Node left;
		Node right;
	}

	public String serialize(Node root) {
		StringBuffer preOrder = preOrder(root, new StringBuffer(""));
		StringBuffer inOrder = indOrde(root, new StringBuffer(""));
		return preOrder.append("--").append(inOrder.toString()).toString();
	}

	public Node deserialize(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		String[] split = str.split("--");
		if (split == null || split.length < 2) {
			return null;
		}

		String pre = split[0];
		String in = split[1];

		System.out.println(pre);
		System.out.println(in);

		String[] preT = pre.split("-");
		if (preT == null || preT.length <= 1) {
			return null;
		}

		int[] preA = new int[preT.length - 1];
		for (int i = 0; i < preA.length; i++) {
			preA[i] = Integer.parseInt(preT[i + 1]);
		}

		String[] inT = in.split("-");
		if (inT == null || inT.length <= 1) {
			return null;
		}

		int[] inA = new int[inT.length - 1];
		for (int i = 0; i < inA.length; i++) {
			inA[i] = Integer.parseInt(inT[i + 1]);
		}

		return getTreeFromInPreOrder(preA, inA, 0, 0, inA.length - 1);

	}

	private Node getTreeFromInPreOrder(int[] preA, int[] inA, int pst, int inst, int inend) {

		if (pst >= preA.length || inst > inend) {
			return null;
		}
		int rootData = preA[pst];
		int rootInInOrder = 0;

		for (int i = inst; i <= inend; i++) {
			if (inA[i] == rootData) {
				rootInInOrder = i;
			}
		}

		int leftSize = rootInInOrder - inst;

		Node root = new Node(rootData);
		root.left = getTreeFromInPreOrder(preA, inA, pst + 1, inst, rootInInOrder - 1);
		root.right = getTreeFromInPreOrder(preA, inA, pst + leftSize + 1, rootInInOrder + 1, inend);

		return root;
	}

	private StringBuffer indOrde(Node root, StringBuffer sb) {
		if (root == null) {
			return sb;
		}
		indOrde(root.left, sb);
		sb.append("-").append(root.data);
		indOrde(root.right, sb);

		return sb;
	}

	private StringBuffer preOrder(Node root, StringBuffer sb) {
		if (root == null) {
			return sb;
		}
		sb.append("-").append(root.data);
		preOrder(root.left, sb);
		preOrder(root.right, sb);

		return sb;
	}

}
