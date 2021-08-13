
class Collection {
	private Deck decks[];
	private int size = 10;
	private int capacity = 5;
	private int count = 0;
	
	//size 10         size 10 * 2
	// capacity 5  -> capacity 5 * 2
	//count 5         count 5
	// Deck d1 , Deck d2 , Deck d3, Deck d4, Deck d5
	
	Collection(){
		decks = new Deck[size];
	}
	public boolean decrementCount() {
		if(count == 0 ) return false;
		else {
			count--;
			return true;
		}
	}
	public int getCapacity() {
		return capacity;
	}
	
	public int getSize() {
		return size;
	}
	public int getCount() {
		return count;
	}
	public void increaseSizeOfArray() {
		Deck[] decks_temp = new Deck[size * 2];
		for(int i = 0 ; i < getCount() ; i++) {
			decks_temp[i] = this.decks[i];
		}		
		decks = decks_temp;
		size *= 2;
		capacity*=2;
	}
	
	public void spaceAvailable(final int count) {
		if(getCount() >= getCapacity()) {
			increaseSizeOfArray();
		}
		
	}
	
	public void push(final Deck element) {
		spaceAvailable(getCount());
		decks[getCount()] = element;
		count++;
	}
	
	public void print() {
		for(int i = 0 ; i < count ; ++i) {
			System.out.println(decks[i].getName() + " ");
		}
	}
	
	public Deck getElement(final int i) {
		return decks[i];
		
	}
	
	public void removeElement(final int index) {
		for(int i = index; i < getCount() ;i++) {
			decks[i] = decks[i+1];
			
		}
		decrementCount();
	}
	
	public int indexOf(final String element) {
		for(int i= 0 ; i < getCount(); i++) {
			if((decks[i].getName()).equals(element)) return i;
		}
		return -1;
	}
	
	//check if deck found
	public boolean isDeckFound(final String deckName) {
		if(indexOf(deckName) == -1) return false;
		return true;
	}
	
	
	
	
}
