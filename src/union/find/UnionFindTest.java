package union.find;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnionFindTest {

	@Test
	public void testFind() {
		QuickFind uf = new QuickFind(4);
		for (int i = 0; i < 4; i++) {
			assertEquals(i, uf.find(i));
		}
	}
	
	@Test
	public void testConnected() throws Exception {
		QuickFind uf = new QuickFind(4);
		assertTrue(uf.connected(0, 0));
		assertFalse(uf.connected(0, 1));
	}
	
	@Test
	public void testUnion() throws Exception {
		QuickFind uf = new QuickFind(4);
		uf.union(0, 1);
		assertTrue(uf.connected(0, 1));
		assertFalse(uf.connected(1, 2));
	}
	
	@Test
	public void testQuizQuickFind() throws Exception {
		QuickFind uf = new QuickFind(10);
		uf.union(8, 9);
		uf.union(7, 2);
		uf.union(1, 2);
		uf.union(8, 1);
		uf.union(8, 4);
		uf.union(0, 7);
		System.out.println(uf);
	}

}
