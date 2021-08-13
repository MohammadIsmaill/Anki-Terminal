public class vector {
	private String arr[];
	private int size = 10;
	private int capacity = 5;
	private int count = 0;
	
	vector(){
		arr = new String[size];
	}
	
	//count is always positive
	public boolean decrementCount() {
		if(count == 0 ) return false;
		else {
			count--;
			return true;
		}
	}
	
	//add element of type string to the dynamic array at certain index
	public void addElement(int index,String element){
		count++;
		spaceAvailable(getCount());
		for(int i = getCount() -1 ; i >= index;i--) {
			arr[i+1] = arr[i];
		}
		arr[index] = element;
		
	}
	
	//return capacity which is half size of vector
	public int getCapacity() {
		return capacity;
	}
	
	//return real size of vector
	public int getSize() {
		return size;
	}
	
	//return number of elements to added to vector
	public int getCount() {
		return count;
	}
	
	//double the size of vector
	public void increaseSizeOfArray() {
		String[] arr_temp = new String[size * 2];
		for(int i = 0 ; i < getCount() ; i++) {
			arr_temp[i] = this.arr[i];
		}		
		arr = arr_temp;
		size *= 2;
		capacity*=2;
	}
	
	
	//change the size of vector when number of elements is greater than or equal to capacity
	public void spaceAvailable(final int count) {
		if(getCount() >= getCapacity()) {
			increaseSizeOfArray();
		}
		
	}
	//add element to the end of vector
	public void push(String element) {
		spaceAvailable(getCount());
		arr[getCount()] = element;
		count++;
	}
	
	
	//print all elements of vector
	public void print() {
		for(int i = 0 ; i < count ; ++i) {
			System.out.println(arr[i] + " ");
		}
	}
	
	
	//return element of vector at a certain index
	public String getElement(int i) {
		return arr[i];	
	}
	
	//remove element of vector at a certain index
	public void removeElement(int index) {
		for(int i = index; i < getCount() ;i++) {
			arr[i] = arr[i+1];
			
		}
		decrementCount();
	}
}
