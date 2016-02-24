package symboltable;

import org.junit.Test;

public class BinarySearchTreeTest {

	 @Test
	 public void test() {
	 BinarySearchTree<Integer, String> st = new BinarySearchTree<>();
	 st.insert(4, "Four");
	 st.insert(3, "Three");
	 st.insert(1, "One");
	 st.insert(5, "Five");
	 st.insert(2, "Two");
	 st.insert(9, "Nine");
	 st.insert(7, "Seven");
	 st.insert(6, "Six");
	 System.out.println(st.get(2));
	 }
	 
	 @Test
	 public void bfs() { 
		 BinarySearchTree<Integer, String> st = new BinarySearchTree<>();
		 st.insert(4, "Four");
		 st.insert(3, "Three");
		 st.insert(1, "One");
		 st.insert(5, "Five");
		 st.insert(2, "Two");
		 st.insert(9, "Nine");
		 st.insert(7, "Seven");
		 st.insert(6, "Six");
		 st.breadthFirstSearch();
	 }
	 
	 @Test
	 public void preOrder() { 
		 BinarySearchTree<Integer, String> st = new BinarySearchTree<>();
		 st.insert(4, "Four");
		 st.insert(3, "Three");
		 st.insert(1, "One");
		 st.insert(5, "Five");
		 st.insert(2, "Two");
		 st.insert(9, "Nine");
		 st.insert(7, "Seven");
		 st.insert(6, "Six");
		 st.preOrder();
	 }
	 
	 @Test
	 public void inOrder() { 
		 BinarySearchTree<Integer, String> st = new BinarySearchTree<>();
		 st.insert(4, "Four");
		 st.insert(3, "Three");
		 st.insert(1, "One");
		 st.insert(5, "Five");
		 st.insert(2, "Two");
		 st.insert(9, "Nine");
		 st.insert(7, "Seven");
		 st.insert(6, "Six");
		 st.inOrder();
	 }
}
