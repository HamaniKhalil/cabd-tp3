/*
 * TP N°		: 03
 * Version N°	: 01
 * 
 * Titre du TP	: Hash Table
 * 
 * Date			: 26 Octobre 2018
 * 
 * Nom			: Hamani
 * Prenom		: Khalil
 * N° Etudiant	: 21810826
 * 
 * Email		: hamani_khalil@yahoo.fr
 * 
 * Remarques	: N/A
 * 
 * */

package HamaniKhalilTP3;

import static HamaniKhalilTP3.SystemConfiguration.BUFFER_SIZE;
import static HamaniKhalilTP3.SystemConfiguration.THE_NONE_CHARACTER;
import static HamaniKhalilTP3.SystemConfiguration.HASH_NOT_FOUND_RESULT;
import static HamaniKhalilTP3.SystemConfiguration.HASH_EMPTY_INDEX_VALUE;
import static HamaniKhalilTP3.SystemErrors.HASH_OUTOFBOUNDS_MESSAGE;
import static HamaniKhalilTP3.SystemErrors.HASH_BAD_INSERTION_MESSAGE;

public class HamaniKhalilHashTable implements HashTable {
	
	// Finals
	private final int	tableSize	= BUFFER_SIZE + 1;
	
	// Other attributes
	private int		[]	valuesTable	= new int	[tableSize];
	private char	[]	keysTable	= new char	[tableSize];
	
	// Constructors
	public HamaniKhalilHashTable() {
		init();
	}

	// Getters
	public int getTableSize() {
		return tableSize;
	}

	public int [] getValuesTable() {
		return valuesTable;
	}

	public char [] getKeysTable() {
		return keysTable;
	}

	// Setters
	public void setValuesTable(int [] valuesTable) {
		this.valuesTable = valuesTable;
	}
	
	public void setKeysTable(char [] keysTable) {
		this.keysTable = keysTable;
	}
	
	// Initialization methods
	private void init() {
		initValuesTable();
		initKeysTable();
	}
	
	private void initValuesTable() {
		for(int i = 0; i < tableSize; i ++) {
			valuesTable[i]	= HASH_EMPTY_INDEX_VALUE;
		}
	}
	
	private void initKeysTable() {
		for(int i = 0; i < tableSize; i ++) {
			keysTable[i]	= THE_NONE_CHARACTER;
		}
	}
	
	// Override methods
	@Override
	public void put(char key, int value) throws Exception {
		if(key == THE_NONE_CHARACTER) {
			throw new Exception(HASH_BAD_INSERTION_MESSAGE);
		}
		
		int keyIndex = key % tableSize;
		if(keysTable[keyIndex] != THE_NONE_CHARACTER) {
			keysTable[keyIndex]		= key;
			valuesTable[keyIndex]	= value;
		}
		else {
			int cursor		= (keyIndex + 1) % tableSize;
			int iteration	= 0;
			while(keysTable[cursor] != THE_NONE_CHARACTER && iteration < BUFFER_SIZE) {
				cursor = (keyIndex + 1) % tableSize;
				iteration ++;
			}
			
			if(iteration > BUFFER_SIZE) {
				throw new Exception(HASH_OUTOFBOUNDS_MESSAGE);
			}
			
			keysTable[cursor]		= key;
			valuesTable[cursor]		= value;
		}
	}
	
	@Override
	public int get(char key) {
		for(int i = 0; i < tableSize; i ++) {
			if(keysTable[i] == key) {
				return valuesTable[i];
			}
		}
		return HASH_NOT_FOUND_RESULT;
	}
	
	@Override
	public void remove(char key) {
		for(int i = 0; i < tableSize; i ++) {
			if(keysTable[i] == key) {
				keysTable[i]	= THE_NONE_CHARACTER;
				valuesTable[i]	= HASH_EMPTY_INDEX_VALUE;
			}
		}
	}
	
}
