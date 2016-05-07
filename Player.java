package TBA;
import java.util.ArrayList;
public class Player{
	
	int squadMembers=5;
	ArrayList<CounterTerrorists>squad=new ArrayList<CounterTerrorists>(squadMembers);
	Player(){}
	//refills/fills the squad array 
	public void fillSquad(){
		if(squad.size()!=squadMembers){
			squad.add(new CounterTerrorists());
			fillSquad();
		}
	}
}
