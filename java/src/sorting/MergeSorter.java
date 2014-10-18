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
	public List<Integer> sort(List<Integer> list) {
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
	 * Running time O(n)
	 * @param leftSortedSeq
	 * @param rightSortedSeq
	 * @return mergedSortedSequences
	 */
	private List<Integer> merge(List<Integer> leftSortedSeq, List<Integer> rightSortedSeq) {

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
			if(leftSmallestElem < rightSmallestElem) {
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
