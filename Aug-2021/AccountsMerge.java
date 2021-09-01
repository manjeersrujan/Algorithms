import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


/**
 * @author smanjeer
 *
 * 18 Jul 2021 3:59:42 AM
 * 
 * https://leetcode.com/problems/accounts-merge/submissions/
 * 
 */
public class AccountsMerge {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {Map<String, String> emailToName = new HashMap<>();
	Map<String, List<String>> graph = new HashMap<>();

	for (List<String> account : accounts) {
		String name = "";
		for (String email : account) {
			if (name == "") {
				name = email;
				continue;
			}
			graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
			graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
			emailToName.put(email, name);
		}
	}

	List<List<String>> ans = new ArrayList<>();
	Set<String> seen = new HashSet<>();
	for (String email : graph.keySet()) {
		if (!seen.contains(email)) {
			Stack<String> stack = new Stack<>();
			List<String> emailList  =  new ArrayList<>();
			seen.add(email);
			stack.push(email);

			while (!stack.isEmpty()) {
				String curEmail = stack.pop();
				emailList.add(curEmail);
				for (String node : graph.get(curEmail)) {
					if (!seen.contains(node)) {
						stack.push(node);
						seen.add(node);
					}
				}
			}
            Collections.sort(emailList);
			ans.add(emailList);
			emailList.add(0, emailToName.get(email));
		}

	}

	return ans;
}
}
