package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};


	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return dfs(node, new HashMap<Integer,UndirectedGraphNode>());
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> flag) {
		if(node == null)
			return null;
		List<UndirectedGraphNode> neighbors = node.neighbors;
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		flag.put(node.label, newNode);
		for(UndirectedGraphNode no : neighbors) {
			UndirectedGraphNode neighbor;
			if(flag.get(no.label) != null)
				neighbor = flag.get(no.label);
			else
				neighbor = dfs(no,flag);
			newNode.neighbors.add(neighbor);
		}

		return newNode;
	}
}
