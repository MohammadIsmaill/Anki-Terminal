import java.io.File;
import java.util.Scanner;
public class DeckLibrary {
	Scanner input = new Scanner(System.in);
	protected Collection decks;
	protected String path = "C:\\Users\\Lenovo Y500\\eclipse-workspace\\Anki\\src\\";
	DeckLibrary(){
		decks = new Collection();
	}
	
	
	public void displayHelp() {
		System.out.println("Type (help) for getting commands");
		System.out.println("Type (create deck deckname) to create a new deck");
		System.out.println("Type (create card deckname) to create card for your deck");
		System.out.println("Type (show decks) to show all decks available");
		System.out.println("Type (show cards deckname) to show all cards available for your deck");
		System.out.println("Type (drop deck deckname) to delete a deck");
		System.out.println("Type (show path) to show the current path we are import files from");
		System.out.println("Type (import cards to deckname) to import cards to certain file");
		System.out.println("Type (study deckname) to study a deck");
		System.out.println("Type (quit) to close the program");
	}
	public String cut(String sentence,String sub_sentence)
	{
		String name = "";
		for(int i = sub_sentence.length() ; i < sentence.length() ;i++) {
			name += sentence.charAt(i);
		}
		return name;
	}
	public boolean contains(String str, String sub_str) {
		for(int i = 0 ; i < str.length() ;i++) {
			int j = 0;
			while(str.charAt(i) == sub_str.charAt(j)) {
				if(str.charAt(i) == sub_str.charAt(sub_str.length() - 1)
						&& str.charAt(i-1) == sub_str.charAt(sub_str.length() - 2) 
						&& str.charAt(i-2) == sub_str.charAt(sub_str.length() - 3)) {
						
					return true;
				}
				i++;
				j++;
			}
		
		}
		return false;
	}
	
	public void createDeck(final String name) {
		decks.push(new Deck(name));
		System.out.println("You successfully created your Deck!");
	}
	public void createCardsUsingFile(final String name,final String fileName) 
	throws Exception{
		if(decks.isDeckFound(name)) {
			int foundDeck = decks.indexOf(name);
			File cards_file = new File(path + fileName + ".txt");
		
			if(cards_file.exists()) {
				Scanner sc1 = new Scanner(cards_file);
				
				
				while(sc1.hasNextLine()) {
					String question = sc1.nextLine();
					String answer = sc1.nextLine();
					decks.getElement(foundDeck)
					.addCard(question, answer);
					
				}
				
				System.out.println("Cards are imported");
				sc1.close();
			}else {
				System.out.println("File does not exist");
			}
			
			
		}else {
			System.out.println("Deck is not found");
		}
	}
	public void createCard(final String name) {
		if(decks.isDeckFound(name)) {
			System.out.println("Enter your card question");
			String question = input.nextLine();
			System.out.println("Enter your card answer");
			String answer = input.nextLine();
			
			int foundDeck = decks.indexOf(name);
			
			decks
			.getElement(foundDeck)
			.addCard(question, answer);
			System.out.println("You successfully created your card!");
		}
		else System.out.println("Deck is not found");
	}
	public void studyDeck(final String name) {
		if(decks.isDeckFound(name)) {
			int foundDeck = decks.indexOf(name);
			Deck deck = decks.getElement(foundDeck);
			
			while(decks.getElement(foundDeck).getCount() != 0) {
				deck.displayFront(0);
				String sc = input.nextLine();
				if(sc.equals("show")) {
					deck.displayBack(0);
					sc = input.nextLine();
					if(sc.equals("easy")) {
						deck.removeCard(0);
					}
					else if(sc.equals("again")) {
						continue;
					}
				}
				
			}
			System.out.println("You have studied all deck");
		}
		else {
			System.out.println("Deck is not found");
		}
	}
	public void showDecks() {
		if(decks.getCount() == 0) {
			System.out.println("There are no decks created yet");
		}
		else {
			decks.print();
		}
	}
	public void showCards(final String name) {
		if(decks.isDeckFound(name)) {
			int foundDeck = decks.indexOf(name);
			if(decks.getElement(foundDeck).getNumberOfCards() != 0) {
				decks
				.getElement(foundDeck)
				.displayAllCards();	
			}
			else {
				System.out.println("There are no cards in this deck");
			}
			
		}
		else{
			System.out.println("Deck is not found");
		}
	}
	
	public void dropDeck(final String name) {
		if(decks.isDeckFound(name)) {
			int foundDeck = decks.indexOf(name);
			decks.removeElement(foundDeck);
			System.out.println("You successfully dropped a deck");
		}else {
			System.out.println("Deck is not found");
		}
	}
	public void showPath() {
		
		System.out.println(path);
	}
	public void changePath(String path) {
		if(new File(path).isDirectory()) {
			this.path = path;
			System.out.println("Path is changed");
		}
		else {
			System.out.println("Path does not exist");
		}
	}
	
	
}
