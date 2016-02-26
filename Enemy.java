
public class Enemy extends Troop{
	int charges=0;
	int flashes=0;
	int windowLeft=0;
	int windowRight=0;
	int door=0;
	int ceiling=0;
	int equipment;
	//approaches
	//will return 1 for door flash or 2 for doorCharge
	public int door(Room room, Troop troopleft, Troop troopright, int charge, int flash){
		door=1;
		int doorFlash=0;
		int doorCharge=0;
		if(flashes==2){
			System.out.println("You have no more flashes");
			if(flash==1){
				flashes=1;
				charges=0;
				equipment+=1;
				if(room.doorLeft+room.doorRight>=1){
					troopleft.health=0;
					troopright.health=0;
				}
				doorFlash=1;
				return doorFlash;
			}
		}
		if(charge==1){
			charges=1;
			doorCharge=2;
			return doorCharge;
		}
		else return 0;

	}
	public void windowLeft(int charge, int flash){
		
	}
	public void windowRight(int charge, int flash){
		
	}
	public void ceiling(){
		
	}
	public void regular(){
		
	}
	public void equipmentRunout(){
		if(equipment==2)System.out.println("you do not have enough equipment for that approach so this will be taken regularly");
	}
	public void chargeEffect(){
		
	}
}
