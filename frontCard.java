public class frontCard extends Card{	
	frontCard(final String question){
		super(question);
	}
	public void frontDisplay() {
		System.out.println("-----------------------------");
		System.out.println(super.question);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("-----------------------------");
		System.out.println("type(show)");
	}
}
