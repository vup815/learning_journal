## Definition:
A minimum spanning tree is a spanning tree with the minimum possible total edge weight in a `weighted undirected graph`. 
1. No cycle
2. Number of edges = Number of vertices - 1

#### Kruskal’s Algorithm:
**Intuition**: Which `edge` with the minimum weight can be add to MST.

**Approach**:
1. Sort all the edges in the ascending order.
2. Start adding the edges to MST.
3. For each edge, verify whether the two vertices connected by the edges are already connected in the MST with 'Union Find'.

**Pseudo Code**:
```
# n = number of vertices 
edges.sort()
uf = UF(n)
mst = []

for edge in edges:
	u, v = edge
	if not uf.connected(u, v):
		 mst.add(edge)
		 uf.union(u, v)
   
return len(mst) == n - 1
```

**Time Complexity**:  `O(E  * log E), E = number of edges`
* Sorting all the edges will take O(E log E) time.
* For each edge, we check whether we can add it to the MST with Union Find, which takes O(1) time in average if we do path compression. So the process will take O(E) time.
* Therefore the time complexity is O(E log E + E) = O(E log E)

**Space Complexity**: `O(V). V = number of vertices`
* Keeping track of *the root of every vertex in the union-find data structure requires O(V) space. 

#### Prim’s Algorithm:

**Intuition**:  Which vertex can be added next into the MST

**Approach**:
1. Arbitrarily pick a vertex to be added to the priority queue.
2. While the queue is not empty, pick the first vertex from the queue.
3. Check if the vertex is already in MST with a boolean array.
4. Add all the vertex which connects with the vertex.

**Pseudo Code**:
```
# n = number of vertices 
inTree = [False] * n
priority_queue.append((0, start))
mst = []

while queue:
	weight, node = priority_queue.pop()
	mst.add(node)
	inTree[node] = True
	for w, adj in adjs[node]:
		if not inTree[adj]:
			queue.append((w, adj))
```

**Time Complexity**:  `O(E  * log E), E = number of edges`
* Time complexity of Priority Queue' add and pop operation is O(log E), and we need to do E times.


**Space Complexity**: `O(V). V = number of vertices`
* We need to store V vertices in our data structure.