package com.bourjm.algos;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringsTest {

	@Test
	public void reverseString() {
		Strings strings = new Strings();
		assertTrue(strings.reverse("abc").equals("cba"));
	}

}
