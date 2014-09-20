package doublingTest;

public class BinarySearch {

	/**
	 * @param key an integer 
	 * @param a a sorted array of integers
	 * @return the index of key in the array if found, else returns -1.
	 */
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if(key > a[mid]) 
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}
