import java.util.Scanner;


public class App extends DeckLibrary{
	static Scanner input = new Scanner(System.in);	
	App(){	
		super();
	}
	
	public void Run() throws Exception{
		System.out.println("Welcome to Anki Terminal");
		System.out.println("Type (help) for getting commands");
		String str = "";
		

		while(!str.equals("quit")) {
			try {
				str = input.nextLine();
				
				if(str.equals("help")) {
					super.displayHelp();
				}
			
				else if(super.contains(str,"create deck ")) {
					String deckName = super.cut(str,"create deck ");
					super.createDeck(deckName);
				}

				else if(super.contains(str,"create card ")) {
					String deckName = cut(str,"create card ");
					super.createCard(deckName);
									
				}
		
				else if(str.equals("show decks")) {
					super.showDecks();
				}
				
			
				else if(super.contains(str,"show cards ")) {
					String deckName = super.cut(str,"show cards ");
					super.showCards(deckName);
					
				}
				else if(super.contains(str, "import cards to ")) {
					String deckName = super.cut(str, "import cards to ");
					System.out.println("Enter the name of the file you want to import");
					String fileName = input.nextLine();
					super.createCardsUsingFile(deckName,fileName);
				}
				
				else if(super.contains(str,"study ")) {	
					String deckName = super.cut(str, "study ");
					super.studyDeck(deckName);
				}
				
				
				else if(super.contains(str,"drop ")) {
					String deckName = super.cut(str,"drop ");
					super.dropDeck(deckName);
					
				}
				else if(str.equals("show path")) {
					super.showPath();
				}
				else if(str.equals("change path")) {
					System.out.println("Enter new path: ");
					String path = input.nextLine();
					super.changePath(path);
				}
					
				else{
					System.out.println("Wrong command");
					System.out.println("Type (help) for getting commands");
				}
			}catch(ArrayIndexOutOfBoundsException exception) {
				System.out.println("Wrong command");
				System.out.println("Type (help) for getting commands");
			}catch(StringIndexOutOfBoundsException exception) {
				System.out.println("Wrong command");
				System.out.println("Type (help) for getting commands");
			}
			
			
		}
	}
	
	

	
}
