import java.util.*;
public class Main {
	Room room = new Room();
	ArrayList<Troop>Troops=new ArrayList<Troop>(5);
	ArrayList<Troop>Enemy=new ArrayList<Troop>(5);
	GameRules standard = new GameRules();
	Player you = new Player();
	public void main(String[] args) {
		menu();
	}
	public void menu(){
		Scanner menu = new Scanner(System.in);
		System.out.println("welcome to base attack name pending");
		System.out.println("1-Play");
		System.out.println("2-Options");
		System.out.println("3-Rules");
		System.out.println("4-Exit");
		if(menu.nextInt()==1){
			playMenu();
		}
		if(menu.nextInt()==2){
			options();
		}
		if(menu.nextInt()==3){
			readme();
		}
		if(menu.nextInt()==4){
			exit();
		}
		menu.close();
	}
	public void options(){
		
	}
	public void readme(){
		
	}
	public void exit(){
		
	}
	public void playMenu(){
		Scanner playMenu = new Scanner(System.in);
		System.out.println("1- vsComp");
		System.out.println("2- vsPlayer");
		System.out.println("3- Go Back");
		if(playMenu.nextInt()==1){
			vsCpu();
		}
		if(playMenu.nextInt()==2){
			vsPlayer();
		}
		if(playMenu.nextInt()==3){
			menu();
		}
		playMenu.close();
	}
	public void vsPlayer(){
		
	}
	public void perkSelection(){
		//ArrayList<String> defencePerks = new ArrayList<String>(8);
		
		if(you.roundsWon==0){
			System.out.println("perk1+details");
			System.out.println("perk2+details");
			System.out.println("perk3+details");
			System.out.println("perk4+details");
			
		}
		if(you.roundsWon==1){
			System.out.println("perk1+details");
			System.out.println("perk2+details");
			System.out.println("perk3+details");
			System.out.println("perk4+details");
		}
	}
	public void vsCpu(){
		perkSelection();
	}
}