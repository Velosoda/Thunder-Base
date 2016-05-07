package TBA;
import java.util.*;

public class Main {
	Scanner allIn = new Scanner(System.in);
	Room room = new Room();
	ArrayList<CounterTerrorists>Troops=new ArrayList<CounterTerrorists>(5);
	ArrayList<Troop>Enemy=new ArrayList<Troop>(5);
	GameRules standard = new GameRules();
	Player you = new Player();
	Enemy cpu = new Enemy();
	public static void main(String[] args) {
		new Main().menu();
	}
	public void menu(){
		Scanner menu = new Scanner(System.in);
		you.fillSquad();
		System.out.println("Thunder Base Alpha!");
		System.out.println("1-Play");
		System.out.println("2-Options");
		System.out.println("3-Rules");
		System.out.println("4-Exit");
		cpu.aiPositions();
		cpu.equipmentGet();
		System.out.println();
		System.out.println("Where the ts are going");
		System.out.println("left window "+cpu.leftWindow.size());
		System.out.println("right window "+cpu.rightWindow.size());
		System.out.println("door "+cpu.door.size());
		System.out.println("ceiling "+cpu.ceiling.size());
		System.out.println();
		System.out.println("Equipment at the start ");
		System.out.println("charges "+cpu.charges);
		System.out.println("flashes "+cpu.flashes);
		while(cpu.flashes>0){
			Random r =new Random();
			if(r.nextInt(3)==0){
				cpu.equipmentEquip(cpu.flashes, 1, cpu.leftWindow);
				if(cpu.leftWindow.size()>0 && cpu.leftWindow.get(0).equipment==1)cpu.flashes--;
			}
			if(r.nextInt(3)==1){
				cpu.equipmentEquip(cpu.flashes, 1, cpu.rightWindow);
				if(cpu.rightWindow.size()>0 && cpu.rightWindow.get(0).equipment==1)cpu.flashes--;
			}	
			if(r.nextInt(3)==2){
				cpu.equipmentEquip(cpu.flashes, 1, cpu.door);
				if(cpu.door.size()>0 && cpu.door.get(0).equipment==1)cpu.flashes--;
			}
		}
		cpu.equipmentEquip(cpu.charges, 2, cpu.leftWindow);
		if(cpu.leftWindow.size()>0 && cpu.leftWindow.get(0).equipment==2)cpu.charges--;
		
		cpu.equipmentEquip(cpu.charges, 2, cpu.rightWindow);
		if(cpu.rightWindow.size()>0 && cpu.rightWindow.get(0).equipment==2)cpu.charges--;
		
		cpu.equipmentEquip(cpu.charges, 2, cpu.door);
		if(cpu.door.size()>0 && cpu.door.get(0).equipment==2)cpu.charges--;
		
		
		System.out.println();
		System.out.println("Whos got what ");
		if(cpu.ceiling.size()==5)System.out.println("ceiling Equipment "+cpu.ceiling.get(0).equipment);
		if(cpu.leftWindow.size()>0)System.out.println("left window equipment "+cpu.leftWindow.get(0).equipment);
		if(cpu.rightWindow.size()>0)System.out.println("right window equipment "+cpu.rightWindow.get(0).equipment);
		if(cpu.door.size()>0)System.out.println("door equipment "+cpu.door.get(0).equipment);
		System.out.println();
		System.out.println("Equipment at the end");
		System.out.println("charges "+cpu.charges);
		System.out.println("flashes "+cpu.flashes);

		
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
	public void map(){
		
	}
	public void playMenu(){
		Scanner playMenu = new Scanner(System.in);
		System.out.println("1- vsComp");
		System.out.println("2- vsPlayer");
		System.out.println("3- Go Back");
		if(playMenu.nextInt()==1){
			vsComp();
		}
		if(playMenu.nextInt()==2){
			vsPlayer();
		}
		if(playMenu.nextInt()==3){
			menu();
		}
		playMenu.close();
	}
	private void vsPlayer() {
		// TODO Auto-generated method stub
		
	}
	public void vsComp(){
		//entry: Entry strategy execution
		//enter: actual entry in to the base
		setup();
		entries();
		peek();
		enter();
		cleanup();
		
	}
	private void cleanup() {
		//1v1s happen until no one from the one of the teams are left standing 
	}
	private void enter() {
		//all the left over enemies enter at once
	}
	private void peek() {
		//one person peeks from each appropriate entrance determining the first kills 
		
	}
	public void entrySituationHandler(ArrayList<Terrorists> approachesArray, int approachId, int equipment){
		if(approachesArray.size()>0 && equipment==1 || equipment==2){
			if(equipment==1){//flashes
				if(approachId==1){//leftwindow
					for(int i=0; i<Troops.size(); i++){
						if(Troops.get(i).coordinates=="Q2"||Troops.get(i).coordinates=="Q3"){
							Troops.get(i).shocked+=1;
							Troops.get(i).mentalAlgorithms();
							Troops.get(i).aimChanges();
							Troops.get(i).mentalStateChar();
						}
					}
				}
				if(approachId==2){//rightwindow
					for(int i=0; i<Troops.size(); i++){
						if(Troops.get(i).coordinates=="Q1"||Troops.get(i).coordinates=="Q4"){
							Troops.get(i).shocked+=1;
							Troops.get(i).mentalAlgorithms();
							Troops.get(i).aimChanges();
							Troops.get(i).mentalStateChar();
						}
					}
				}
				if(approachId==3){//door
					for(int i=0; i<Troops.size(); i++){
						if(Troops.get(i).coordinates=="Q3"||Troops.get(i).coordinates=="Q4"){
							Troops.get(i).shocked+=1;
							Troops.get(i).mentalAlgorithms();
							Troops.get(i).aimChanges();
							Troops.get(i).mentalStateChar();
						}
					}
				}
			}
		}
		if(equipment==2){//charges
			if(approachId==1){//leftwindow
				for(int i=0; i<Troops.size(); i++){
					if(Troops.get(i).coordinates=="Q2"||Troops.get(i).coordinates=="Q3"){
						Troops.get(i).shocked+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
						if(Troops.get(i).position==5 || Troops.get(i).position==6){
							Troops.get(i).health=0;
							System.out.println("You lost a Troop Due to a Charge exploding");
						}
					}
					if(Troops.get(i).coordinates=="Q1"||Troops.get(i).coordinates=="Q4"){
						Troops.get(i).alert+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
					}
				}
			}
			if(approachId==2){//rightwindow
				for(int i=0; i<Troops.size(); i++){
					if(Troops.get(i).coordinates=="Q1"||Troops.get(i).coordinates=="Q4"){
						Troops.get(i).shocked+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
						if(Troops.get(i).position==7 || Troops.get(i).position==8){
							Troops.get(i).health=0;
							System.out.println("You lost a Troop Due to a Charge exploding");
						}
					}
					if(Troops.get(i).coordinates=="Q2"||Troops.get(i).coordinates=="Q3"){
						Troops.get(i).alert+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
					}
				}
			}
			if(approachId==3){//door
				for(int i=0; i<Troops.size(); i++){
					if(Troops.get(i).coordinates=="Q3"||Troops.get(i).coordinates=="Q4"){
						Troops.get(i).shocked+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
						if(Troops.get(i).position==9 || Troops.get(i).position==10){
							Troops.get(i).health=0;
							System.out.println("You lost a Troop Due to a Charge exploding");
						}
					}
					if(Troops.get(i).coordinates=="Q1"||Troops.get(i).coordinates=="Q2"){
						Troops.get(i).alert+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
					}
				}	
			}
			if(approachId==4){//ceiling
				for(int i=0; i<Troops.size(); i++){
					if(Troops.get(i).coordinates=="In the room"){
						Troops.get(i).health=0;
					}
					if(Troops.get(i).coordinates!="In the room"){
						Troops.get(i).alert+=1;
						Troops.get(i).mentalAlgorithms();
						Troops.get(i).aimChanges();
						Troops.get(i).mentalStateChar();
					}
				}
			}
		}
	}
	private void entries() {
		//enemy executes the approach
		//The following handles pre entry situations from here....
		System.out.println("we are in entries");
		for(int i=0; i<Troops.size(); i++){
			System.out.println("Squad member "+(i+1)+" is in position "+Troops.get(i).position);
			Troops.get(i).cooridinateSet();
			Troops.get(i).mentalStateChar();
			System.out.println("Troop "+(i+1)+" is in Quadrant "+Troops.get(i).coordinates);
		}
		if(cpu.door.size()>0 && room.doorLeft==1 || room.doorRight==1){
			for(int i=0; i<Troops.size(); i++){
				if(Troops.get(i).coordinates.equals("Q3") ||  Troops.get(i).coordinates.equals("Q4")){
					Troops.get(i).clearMentalState();
					Troops.get(i).alert+=1;
					Troops.get(i).mentalAlgorithms();
					Troops.get(i).aimChanges();
					Troops.get(i).mentalStateChar();
					
				}
			}
		}
		if(cpu.ceiling.size()>0){
			for(int i=0; i<Troops.size(); i++){
				if(Troops.get(i).coordinates!="Q2"){
					Troops.get(i).clearMentalState();
					Troops.get(i).alert+=1;
					Troops.get(i).mentalAlgorithms();
					Troops.get(i).aimChanges();
					Troops.get(i).mentalStateChar();
				}
			}
		}
		for(int i=0; i<Troops.size(); i++){
			System.out.println("Mental State: "+Troops.get(i).mentalState);
		}
		//...to here
		//The following will handle the actual entries
		entrySituationHandler(cpu.leftWindow, 1, 1);
	}
	private void setup() {
		//pick positions
		//pick perks
		System.out.println("we are in setup");
		mapOfRoom();
		room.displayAvailiblePositions(room.getTopRight(), "1: Top Right Corner");
		room.displayAvailiblePositions(room.getTopLeft(), "2: Top Left Corner");
		room.displayAvailiblePositions(room.getBottomLeft(), "3: Bottom Left Corner");
		room.displayAvailiblePositions(room.getBottomRight(), "4: Bottom Right Corner");
		room.displayAvailiblePositions(room.getLeftWindowTop(), "5: Left Window: Top");
		room.displayAvailiblePositions(room.getLeftWindowBottom(), "6: Left Window: Bottom");
		room.displayAvailiblePositions(room.getRightWindowTop(), "7: Right Window: Top");
		room.displayAvailiblePositions(room.getRightWindowBottom(), "8: Right Window: Bottom");
		room.displayAvailiblePositions(room.getDoorRight(), "9: Right Of Door");
		room.displayAvailiblePositions(room.getDoorLeft(), "10: Left Of Door");
		room.displayAvailiblePositions(room.getMid(), "11: In the room ");
		if(you.squad.size()>0){
			System.out.println("Where do you want to place troop "+ (room.howmanypeopleareintheroom()+1));
			int positionInput=allIn.nextInt();
			if(positionInput==1){
				room.topRight=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=1;
				setup();
			}
			if(positionInput==2){
				room.topLeft=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=2;
				setup();
			}
			if(positionInput==3){
				room.bottomLeft=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=3;
				setup();
			}
			if(positionInput==4){
				room.bottomRight=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=4;
				setup();
			}
			if(positionInput==5){
				room.leftWindowTop=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=5;
				setup();
			}
			if(positionInput==6){
				room.leftWindowBottom=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=6;
				setup();
			}
			if(positionInput==7){
				room.rightWindowTop=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=7;
				setup();
			}
			if(positionInput==8){
				room.rightWindowBottom=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=8;
				setup();
			}
			if(positionInput==9){
				room.doorRight=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=9;
				setup();
			}
			if(positionInput==10){
				room.doorLeft=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=10;
				setup();
			}
			if(positionInput==11){
				room.mid=1;
				Troops.add(you.squad.get(you.squad.size()-1));
				you.squad.remove(you.squad.size()-1);
				Troops.get(Troops.size()-1).position=11;
				setup();
			}
		}
		entries();
	}
	public void perkSelection(){

	}
	public void mapOfRoom(){
		System.out.println(" _____________________________________________________________");
		System.out.println("|"+room.topLeft+"  |             |                          |            |  "+room.topRight+"|");
		System.out.println("|_                |                          |               _|");
		System.out.println("|                 |                          |                |");
		System.out.println("|                 |                          |                |");
		System.out.println("|                 |                          |                |");
		System.out.println("|                 |           "+room.mid+"              |                |");
		System.out.println("|                 |                          |                |");
		System.out.println("|                 |                          |                |");
		System.out.println("|                 |                          |                |");
		System.out.println("|"+room.leftWindowTop+"                |__________________________|               "+room.rightWindowTop+"|");
		System.out.println("                                                                ");
		System.out.println("                                                                 ");
		System.out.println("                                                                 ");
		System.out.println("                                                                 ");
		System.out.println("|"+room.leftWindowBottom+"                                                           "+room.rightWindowBottom+"|");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|                                                             |");
		System.out.println("|__                                                         __|");
		System.out.println("|"+room.bottomLeft+"                                                           "+room.bottomRight+"|");
		System.out.println("|__|_______________________"+room.doorLeft+"       "+room.doorRight+"_______________________|__|");
		System.out.println("                              Door                         ");
	}
}
