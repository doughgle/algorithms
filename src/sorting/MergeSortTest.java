package sorting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MergeSortTest {

	private MergeSorter sorter;

	@Before
	public void setUp() {
		sorter = new MergeSorter();
	}

	@Test
	public void testGivenNullSequenceShouldThrowIllegalArgumentException() {
		try {
			sorter.sort(null);
			fail("Given Null seq should throw illegal argument exception");
		} catch (IllegalArgumentException e){
		}
	}
	
	@Test
	public void testGivenEmptySequenceReturnsEmptySequence() {
		assertEquals(new ArrayList<Integer>(), sorter.sort(new ArrayList<Integer>()));
	}

	@Test
	public void testGivenSequenceOfOneReturnsThatSequence() {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		assertSame(seq, sorter.sort(seq));
	}
	
	@Test
	public void testGivenUnsortedSequenceOfTenUniqueElementsReturnsSortedSeq() {
		List<Integer> seq = Arrays.asList(2, 1, 4, 3, 5, 9, 10, 8, 6, 7);
		List<Integer> expectedSeq = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertEquals(expectedSeq, sorter.sort(seq));
	}

	@Test
	public void testGivenUnsortedSequenceWithDuplicateElementsReturnsSortedSeq() {
		List<Integer> seq = Arrays.asList(2, 1, 2, 3, 5);
		List<Integer> expectedSeq = Arrays.asList(1, 2, 2, 3, 5);
		assertEquals(expectedSeq, sorter.sort(seq));
	}
	
	@Test
	public void testPerformanceWithLargeInputSize() {
		List<Integer> seq = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 100000; i++) {
			seq.add(random.nextInt(10));
		}
		
		List<Integer> expectedSeq = new ArrayList<Integer>(seq); 
		Collections.sort(expectedSeq);
		assertEquals(expectedSeq, sorter.sort(seq));
	}

}
