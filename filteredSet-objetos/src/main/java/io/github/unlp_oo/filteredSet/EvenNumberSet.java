package io.github.unlp_oo.filteredSet;

import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer> {
	
	
	@Override
	public boolean add(Integer number) {
		return number % 2 == 0 ? super.add(number) : false;
	}
}
