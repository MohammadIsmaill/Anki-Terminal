
public class Deck {
	private vector questions = new vector();
	private vector answers = new vector();
	private String name;
	static int numberOfDecks = 0;
	private int numberOfCards = 0;
	
	
	public Deck(final String name){
		this.name = name;
		numberOfDecks++;
	}

	public void removeCard(int index) {
		questions.removeElement(index);
		answers.removeElement(index);
		numberOfCards--;
	}
	
	public int getCount() {
		return questions.getCount();
	}
	public void addCard(final String question,final String answer) {
		questions.push(question);
		answers.push(answer);
		numberOfCards++;
	}
	public int getNumberOfCards() {
		return numberOfCards;
	}
	public void displayFront(final int element) {
		new frontCard(
		questions.getElement(element))
		.frontDisplay();
	}
	public void addQuestion(int index,String question) {
		questions.addElement(index, question);
	}
	public void addAnswer(int index, String answer) {
		answers.addElement(index, answer);
	}
	
	public void displayBack(final int element) {
		new backCard(
		questions.getElement(element),
		answers.getElement(element))
		.backDisplay();
	}
	public String getName() {
		return name;
	}
	
	public String getQuestion(int index) {
		return questions.getElement(index);
	}
	public String getAnswer(int index) {
		return answers.getElement(index);
	}
	public void displayAllCards() {
		System.out.println("All cards for " + getName());
		for(int i = 0 ; i < questions.getCount();i++) {
			System.out.println("--------------------------------");
			System.out.println("card: " + (i+1));
			System.out.println("Front: " + questions.getElement(i));
			System.out.println("Back: " + answers.getElement(i));
			System.out.println("---------------------------------");
		}
	}
	
}
