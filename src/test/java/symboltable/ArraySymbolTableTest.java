package symboltable;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySymbolTableTest {

	@Test
	public void putItemsIntoArraySymbolTable() {
		ArraySymbolTable<String, Integer> st = new ArraySymbolTable<>();
		st.put("One", 1);
		st.put("Two", 2);
		st.put("Three", 3);
		assertTrue(st.size() == 3);
		st.put("Four", 4);
		assertTrue(st.size() == 4);
		st.put("Four", 5);
		assertTrue(st.size() == 4);
	}

	@Test
	public void getItemsFromArraySymbolTable() {
		ArraySymbolTable<String, Integer> st = new ArraySymbolTable<>();
		st.put("One", 1);
		st.put("Two", 2);
		st.put("Three", 3);
		assertTrue(st.get("Three") == 3);
		assertTrue(st.contains("Two"));
		assertFalse(st.contains("Six"));
		st.put("One", 11);
		assertTrue(st.get("One") == 11);
		assertNull(st.get("Six"));
	}

	@Test
	public void deleteItemsFromArraySymbolTable() {
		ArraySymbolTable<String, Integer> st = new ArraySymbolTable<>();
		st.put("One", 1);
		st.put("Two", 2);
		st.put("Three", 3);
		assertNull(st.delete("Four"));
		assertTrue(st.size() == 3);
		assertTrue(st.delete("One") == 1);
		assertTrue(st.size() == 2);
		assertTrue(st.delete("Two") == 2);
		assertTrue(st.size() == 1);
		assertTrue(st.delete("Three") == 3);
		assertTrue(st.isEmpty());

	}
}
