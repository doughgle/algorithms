package union.find;

/**
 * Eager algorithm for the find operation
 */
public class QuickFind {

	/** Note: Array indices are elements, array values represent the Id of the component. */
	private int[] id;
	
	public QuickFind(int N) {
		id = new int[N];
		
		// initialise all components to be separate
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	/** Slow union O(n): Change every element whose id equals p to q */
	public void union(int p, int q) {
		for (int i = 0; i < id.length; i++) {
			if(id[i] == p) {
				id[i] = q;
			}
		}
	}
	
	/** Finds Id of p in constant time O(1) (by array lookup) */
	public int find(int p) {
		return id[p];
	}
	
	/** Returns true if p and q are connected, false otherwise */
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuickFind [id=");
		for (int i = 0; i < id.length; i++) {
			builder.append(id[i] + " ");
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
}
