- Single source shortest path algorithm
- There cannot exists a path with negative weight
- Each iteration greedily select the shortest edge to the next vertex with `priority queue`, very similar to [[Minimum Spanning Tree#Prim’s Algorithm]]
- Because the nature of greedy strategy, we never reconsider a vertex after it has been added to the SPT (`shortest path tree`), that's why this algorithm won't work if there's any path with negative weight

```python
# def adjs(v) -> List[(int, int)]: # (vertex, weight)
def dijkstra(start):
    distances = [inf] * n
    distances[start] = 0
    pq = [(0, start)]
    while pq:
        curr_node, curr_w = heapq.heappop(pq)
        if distances[curr_node] < curr_w:
            continue
        for adj_node, weight in adjs(curr_node):
            new_distance = distances[curr_node] + weight
            if new_distance < distances[adj_node]:
                distances[adj_node] = new_distance
                heapq.heappush(pq, (adj, new_distance))
```

**Time Complexity**: O($v^2$ $log {(v)}$)

The time complexity of `priority queue` operation is `logarithmic` and we need to do at most 2 $\times$ e times operation (`enqueue` and `dequeue`). So we can simplify to  O(e  $log {(v)}$) where e = number of edges and v = number of vertices.
In worst case, e = $\frac{v (v-1)}{2}$ ~=  $v^2$, so we get O($v^2$  $log {(v)}$)  
