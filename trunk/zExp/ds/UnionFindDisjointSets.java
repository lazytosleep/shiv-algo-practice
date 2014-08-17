package ds;

public class UnionFindDisjointSets {
	//Represents parent array, for a parent to become top level parent it's index should suffices index = parent[index]
	// no of top level element represent no of sets i.e. top level parent
	static int[] parent;
	//Find top level parent, which represent the set, notice compression happens here
	static int findSet(int i){
		return parent[i]== i ? i : (parent[i]=findSet(parent[i]));
	}
	//make i top level parent as child of j top level parent
	static void unionSet(int i, int j){
		parent[findSet(i)] = findSet(j);
	}
	
	static boolean isSameSet(int i, int j){
		return findSet(i) == findSet(j);
	}

}
