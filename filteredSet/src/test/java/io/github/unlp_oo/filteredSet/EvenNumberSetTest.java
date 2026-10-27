package io.github.unlp_oo.filteredSet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvenNumberSetTest {
	private EvenNumberSet numbers;

	@BeforeEach
	void setUp() {
		this.numbers = new EvenNumberSet();
	}

	@Test
	void addTest() {
		assertFalse(numbers.add(1));
		assertTrue(numbers.add(2));
		assertTrue(numbers.add(4));
		assertFalse(numbers.add(2));
	}

}
