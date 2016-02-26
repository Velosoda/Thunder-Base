
public class Troop {
	int ready=1;
	int alert=0;
	int focused=0;
	int shocked=0;
	int insane=0;
	int aim=5;
	int health=100;
	int position=0;
	boolean targetable = false;

	//this method takes the mental states and gives the troop stat changes 
	public void mentalChanges(){
		if(shocked==1)aim=3;
		if(shocked==2){
			shocked=shocked-2;
			insane=1;
		}
		if(insane==1)aim=(int) (Math.random()+.5);
		if(alert==1)aim=8;
		if(alert==2){
		alert=alert-2;
		focused=1;
		}
		if(focused==1)aim=10;
	}
	//use this method everytime a mental state is going to be changed 
	public void clearMentalState(){
		ready=0;
		alert=0;
		focused=0;
		shocked=0;
		insane=0;
	}
	//use this data to display the current mental state of a certain troop in the map
	public char mentalStateChar(){
		char currentMentalState;
		if(ready==1){
			currentMentalState='R';
			return currentMentalState;
		}
		if(alert==1){
			currentMentalState='A';
			return currentMentalState;
		}
		if(focused==1){
			currentMentalState='F';
			return currentMentalState;
		}
		if(shocked==1){
			currentMentalState='S';
			return currentMentalState;
		}
		if(insane==1){
			currentMentalState='I';
			return currentMentalState;
		}
		else{return ' ';}
	}
}
