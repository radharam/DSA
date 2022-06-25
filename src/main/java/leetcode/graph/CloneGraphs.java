/*

https://leetcode.com/problems/clone-graph
133. Clone Graph


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraphs {
    
    public Node cloneGraph(Node node) {
        
        return cloneGraphBFSImproved(node);
    }
    
    
    // BFS Approach with extra space
    public Node cloneGraphBFSImproved(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node clonedNode = new Node(node.val);
        cloneMap.put(node, clonedNode);
        q.offer(node);
        
        while(!q.isEmpty()) {
            Node origNode = q.poll();
            
            for(Node origNeighbor: origNode.neighbors) {
                if(cloneMap.get(origNeighbor) == null) {
                    Node clonedNeighbor = new Node(origNeighbor.val);
                    cloneMap.put(origNeighbor, clonedNeighbor);
                    q.offer(origNeighbor);
                }
                
                cloneMap.get(origNode).neighbors.add(cloneMap.get(origNeighbor));
            }
        }
        
        return clonedNode;
    }
    
    
    // BFS Approach without extra space
    public Node cloneGraphBFS(Node node) {
        if(node == null) return null;
        Map<Node, Node> cloneMap = new HashMap();
        Set<Node> visited = new HashSet();
        Queue<Node> q = new LinkedList<>();
        
        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);
        q.offer(node);
        visited.add(node);
        while(!q.isEmpty()) {
            Node origNode = q.poll();
            
            for(Node origNeighbor: origNode.neighbors) {
                if(visited.contains(origNeighbor)) {
                    cloneMap.get(origNode).neighbors.add(cloneMap.get(origNeighbor));
                    continue;
                }
                Node newNeighbor = new Node(origNeighbor.val);
                cloneMap.put(origNeighbor, newNeighbor);
                cloneMap.get(origNode).neighbors.add(newNeighbor);
                visited.add(origNeighbor);
                q.add(origNeighbor);
            }
        }
        
        return newNode;
    }
    
    
    // DFS with extra space
    public Node cloneGraphDFS(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> cloneMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> st = new Stack<>();
        Node clonedNode = new Node(node.val);
        cloneMap.put(node, clonedNode);
        st.push(node);
        visited.add(node);
        
        while(!st.isEmpty()) {
            Node origNode = st.pop();
            
            for(Node neighbor: origNode.neighbors) {
                if(visited.contains(neighbor)) {
                    cloneMap.get(origNode).neighbors.add(cloneMap.get(neighbor));
                    continue;
                }
                
                Node clonedNeighbor = new Node(neighbor.val);
                cloneMap.put(neighbor, clonedNeighbor);
                cloneMap.get(origNode).neighbors.add(cloneMap.get(neighbor));
                visited.add(neighbor);
                st.push(neighbor);
            }
        }
        
        return clonedNode;
    }
    
    
    // DFS without extra space
    
    public Node cloneGraphDFS(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> cloneMap = new HashMap();
        Stack<Node> st = new Stack();
        
        Node clonedNode = new Node(node.val);
        cloneMap.put(node, clonedNode);
        st.push(node);
        
        while(!st.isEmpty()) {
            Node origNode = st.pop();
            
            for(Node neighbor: origNode.neighbors) {
                if(cloneMap.get(neighbor) == null) {
                    Node clonedNeighbor = new Node(neighbor.val);
                    cloneMap.put(neighbor, clonedNeighbor);
                    st.push(neighbor);
                }
                
                cloneMap.get(origNode).neighbors.add(cloneMap.get(neighbor));
            }
        }
        
        return clonedNode;
    }
}
