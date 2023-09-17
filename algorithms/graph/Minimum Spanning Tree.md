## Definition:
A minimum spanning tree is a spanning tree with the minimum possible total edge weight in a “weighted undirected graph”.

#### Kruskal’s Algorithm:
Greedy approach, always try to find the minimum edge.

**Mindset**: Can I add this `edge` to the MST ?

**Process**:
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
	if not uf.connected(edge):
		 mst.add(edge)
		 uf.union(edge)
   
return len(mst) == n - 1
```

**Time Complexity**:  `O(E  * log E), E = number of edges`
* Sorting all the edges will take O(E log E) time.
* For each edge, we check whether we can add it to the MST with Union Find, which takes O(1) time in average if we do path compression. So the process will take O(E) time.
* Therefore the time complexity is O(E log E + E) = O(E log E)

**Space Complexity**: `O(V). V = number of vertices`
* Keeping track of the root of every vertex in the union-find data structure requires O(V) space. 