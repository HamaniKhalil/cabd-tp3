package httest;

import static org.junit.Assert.*;
import static HamaniKhalilTP3.SystemErrors.HASH_OUTOFBOUNDS_MESSAGE;
import static HamaniKhalilTP3.SystemErrors.HASH_BAD_INSERTION_MESSAGE;
import static HamaniKhalilTP3.SystemConfiguration.HASH_NOT_FOUND_RESULT;
import static HamaniKhalilTP3.SystemConfiguration.THE_NONE_CHARACTER;

import org.junit.Test;

import HamaniKhalilTP3.HamaniKhalilHashTable;

public class HamaniKhalilTestHashTable {

	@Test
	public void testHashTable() {
		HamaniKhalilHashTable	hashTable	= new HamaniKhalilHashTable();
		
		try {
			hashTable.put('A', 2);
			assertEquals(2, hashTable.get('A'));
			
			hashTable.put('Z', 4);
			assertEquals(4, hashTable.get('Z'));
			
			hashTable.put('R', 0);
			assertEquals(0, hashTable.get('R'));
			
			hashTable.put('I', 3);
			assertEquals(3, hashTable.get('I'));
			
			hashTable.put('H', 9);
			assertEquals(9, hashTable.get('H'));
			
			hashTable.put('T', 7);
			assertEquals(7, hashTable.get('T'));
			
			hashTable.put('G', 1);
			assertEquals(1, hashTable.get('G'));
			
			hashTable.put('K', 6);
			assertEquals(6, hashTable.get('K'));
			
			hashTable.put('M', 5);
			assertEquals(5, hashTable.get('M'));
			
			hashTable.put('C', 8);
			assertEquals(8, hashTable.get('C'));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExceedHasTable() {
		HamaniKhalilHashTable	hashTable	= new HamaniKhalilHashTable();
		
		try {
			for(int i = 0; i < hashTable.getTableSize(); i ++) {
				hashTable.put('A', i);
			}
			
			hashTable.put('Z', 10);			
		} catch (Exception e) {
			assertEquals(HASH_OUTOFBOUNDS_MESSAGE, e.getMessage());
		}
	}
	
	
	@Test
	public void testHashTableRemove() {
		HamaniKhalilHashTable	hashTable	= new HamaniKhalilHashTable();
		
		try {
			hashTable.put('A', 2);
			assertEquals(2, hashTable.get('A'));
			
			hashTable.remove('A');
			assertEquals(HASH_NOT_FOUND_RESULT, hashTable.get('A'));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHashVoidInsertion() {
		HamaniKhalilHashTable	hashTable	= new HamaniKhalilHashTable();
		
		try {
			hashTable.put(THE_NONE_CHARACTER, 2);
		} catch (Exception e) {
			assertEquals(HASH_BAD_INSERTION_MESSAGE, e.getMessage());
		}
	}
	
}
