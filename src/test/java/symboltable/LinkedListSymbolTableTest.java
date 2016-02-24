package symboltable;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListSymbolTableTest {

	@Test
	public void testSymbolTableWithLinkedListImplementation() {
		LinkedListSymbolTable<String, Integer> st = new LinkedListSymbolTable<>();
		st.put("One", 1);
		st.put("Two", 2);
		st.put("Three", 3);
		st.put("Four", 4);
		assertTrue(st.get("Three") == 3);
		assertTrue(st.get("Two") == 2);
		assertTrue(st.get("One") == 1);
		assertNull(st.get("Five"));
		st.put("One", 10);
		assertFalse(st.get("One") == 1);
		assertTrue(st.get("One") == 10);
		assertTrue(st.contains("Two"));
		assertFalse(st.contains("six"));
	}

}
