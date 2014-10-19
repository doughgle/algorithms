package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter {

	/**
	 * Merge sort
	 * 
	 * Running time O(nlog(n))
	 * @param list
	 * @return sortedSequence
	 */
	public static List<Integer> sort(List<Integer> list) throws IllegalArgumentException {
		if(list == null)
			throw new IllegalArgumentException("Expected a sequence, got null.");
		if(list.contains(null))
			throw new IllegalArgumentException("Given sequence contains null element(s).");
		
		// base case
		if(list.size() <= 1)
			return list;
		
		int halfwayIndex = list.size() / 2;
		List<Integer> leftSortedSeq = sort(list.subList(0, halfwayIndex));
		List<Integer> rightSortedSeq = sort(list.subList(halfwayIndex, list.size()));
		return merge(leftSortedSeq, rightSortedSeq);
	}

	/**
	 * Merge step
	 * 
	 * Invariant: When comparing duplicate elements, the relative order is preserved 
	 * (i.e. left element before right element). This is an invariant that's expected 
	 * of Merge Sort and one reason it's preferred over Quicksort, which cannot be made
	 * 'stable' in preserving the original ordering. The reason to preserve relative order 
	 * of otherwise equal elements is that they could have been pre-sorted by another criteria 
	 * (e.g. sorted by first name, then last name).
	 * 
	 * Running time O(n)
	 * @param leftSortedSeq
	 * @param rightSortedSeq
	 * @return mergedSortedSequences
	 */
	private static List<Integer> merge(List<Integer> leftSortedSeq, List<Integer> rightSortedSeq) {

		if(leftSortedSeq.isEmpty())
			return rightSortedSeq;
		else if (rightSortedSeq.isEmpty())
			return leftSortedSeq;
		
		List<Integer> sortedSeq = new ArrayList<>();
		int lIdx = 0;
		int rIdx = 0;
		int leftSortedSize = leftSortedSeq.size();
		int rightSortedSize = rightSortedSeq.size();
		while(lIdx < leftSortedSize && rIdx < rightSortedSize) {
			
			Integer leftSmallestElem = leftSortedSeq.get(lIdx);
			Integer rightSmallestElem = rightSortedSeq.get(rIdx);
			if(leftSmallestElem.compareTo(rightSmallestElem) <= 0) {
				sortedSeq.add(leftSmallestElem);
				lIdx++;
			}
			else {
				sortedSeq.add(rightSmallestElem);
				rIdx++;
			}
		}
		
		// copy over remainder from both seqs
		sortedSeq.addAll(leftSortedSeq.subList(lIdx, leftSortedSize));
		sortedSeq.addAll(rightSortedSeq.subList(rIdx, rightSortedSize));
		return sortedSeq;
	}

}
