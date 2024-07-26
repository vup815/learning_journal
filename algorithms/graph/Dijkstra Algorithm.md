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
        curr_w, curr_v = heapq.heappop(pq)
        if distances[curr_v] < curr_w:
            continue
        for adj, weight in adjs(curr_v):
            if distances[adj] < distances[curr_v] + weight:
                distances[adj] = distances[curr_v] + weight
                heapq.heappush(pq, (distances[adj], adj))
```

**Time Complexity**: O($v^2$ log v)

The time complexity of `priority queue` operation is `logarithmic` and we need to do at most 2e times operation (`enqueue` and `dequeue`). So we can simplify to  O(e log v) where e = number of edges and v = number of vertices.
In worst case, e = v(v-1)/2 ~=  $v^2$, so we get O($v^2$ log v)  
