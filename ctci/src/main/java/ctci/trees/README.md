#Trees and Graphs
* Each tree has a root node
* Root node has zero or more children
* each child node has zero or more children
* tree cannot contain cyles
* nodes may/ may not have links back to their parents

#Trees vs. Binary Trees
* A tree can have many children. 
* A tree can be a ternary tree (3 children)
* **Binary Tree**: each node has max. 2 children
* **Leaf Node**: node without any children

#Binary Tree vs. Binary Search Tree
* Every node fists a specific ordering propertiy
* `All left descendents` <= `n` < `all right descendents`

# Balanced vs. Unbalanced 
* balancing a tree does not always mean that left and right  subtrees are exactly the same size
* sometimes balanced tree means _not terribly inbalanced tree_
* balance ensures O(log n) times for insert and find
* Examples:
* * **Read-black trees**
* * **AVL trees**
# Complete Binary Trees
* Every level of tree is fully filled, except the last level
# Full Binary Tree
* every node has zero or two children
* no nodes have one child
#Perfect Binary Tree
* Both full and complete 
* Have exactly _2^k - 1_ nodes (k is the number of levels)
# Traversal
* `In-order traversal`
* `Pre-order traversal`
* `Post-order traversal`
# Heaps
### Max-Heap
Elements are in descending order
### Min-Heap
Elements are in ascending order
* A complete binary tree where each node is smaller than its children
* root is the minimum
* Two key operations
* * `insert`
* * `extract_min`
#### Insert
* start by inserting at the rightmost bottom to maintain _complete tree_ property
* fix the tree by swapping the element with its parent until the appropriate spot **Bubble Up**
#### Extract Minimum Element
* Min element is always at the top
* remove the min element and swap it with the last element in the heap (bottommost, rightmost element)
* bubble down it, swapping with min. of its children until appropriate place
# Tries (Prefix Trees)
* **trie**:a variant of `n-ary tree`
* characterrs are stored at each node
* each path down may represent a word
* `*` (null) nodes represent complete words
* a node can have anywhere from 1 through ALPHABET_SIZE + 1 children
* Used to store English language for **quick prefix lookups**
* Hash tablse can be used to validate a string
* Trie can validate if a string is a prefix of any valid word
* Validate prefix
* * `O(K)` time, K is the length of the string (same as HashTable precisely)

# GRAPHs
* may contain cycles
* * `cyclic`
* * `acyclic`
* can be 
* * `directed`
* * `undirected`
* can contain multiple isolated subpgraphs
* `connected graph` has paths between every pair of vertices 
## ADJACENCY LIST
Every vertex stores a list of adjacent vertices
* it is undirected
* 

## ADJACENCY MATRIX
* NxN boolean matrix (N:# of nodes)
* `true at matrix[i][j]`:an edge from i to j exists
* can be int instead of boolean
* if undirected, it will be symmetric
* Same graph algorithms can be executed, such as breadth-first search, but less efficiently
* you have to iterate through all nodes to identify a node's neighbours. it is more efficiently to use graph objects

## GRAPH SEARCH
* `depth-first search` : DFS
* `breadth-first search` : BFS
### DFS
* start at root
* explore each branch before moving to next branch
* go deep first before go wide
* preferred if we want to visit every node in the graph
* tree traversals are a form of DFS
* in graph DFS, we should check is the node has already been visited
* **RECURSIVE**
### BFS
* start at root
* explore each neighbor before going on their children
* go wide before go deep
* preferred if we want to find a path (e.g. shortest-path) between two nodes
* Example : find a path to a friendship between two people in the entire world. Going deep puts us far away
* **NON-RECURSIVE**
* It uses `queue`
### Bidirectional Search
* used to find the shortest-path between sourch and destination
* runs two simultaneous breadth-first searches, one from each node
* when two searches collide, path is found

**EXAMPLE:**

`k`:# of adjacent nodes

`s`:starting node

`t`:destination node

`d`:shortest-path length

* In BFS:

Search up to k nodes for each level => `O(k ^ d)`

* In Bidirectional search

Two searches collide after `d/2` levels => `O(k ^ d/2)`

**Additional Reading** 
* Topological Sort
* Dijkstra's Algorithm
* AVL trees
* Red-Black trees