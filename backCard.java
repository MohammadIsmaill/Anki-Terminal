
public class backCard extends Card{
	backCard(final String question,final String answer){
		super(question,answer);
	}
	
	public void backDisplay() {
		System.out.println("-----------------------------");
		System.out.println(super.question);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("-----------------------------");
		System.out.println(super.answer);
		System.out.println("-----------------------------");
		System.out.println("again\teasy");
	}
}
