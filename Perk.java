
public class Perk {
	String name;
	int inUse=0;
	//this constructor will be used primarily for display purposes only
	Perk(int type){
		if(type==1)System.out.println("Corners Boost  : playing a troop in a corner will make that troop alert they cannot become focused or insane");
		if(type==2)System.out.println("Charge Shield  : charges do not kill troops they only leave them shocked");
		if(type==3)System.out.println("Shock Shield   : any troop that is shocked will not get killed in the peek round but will have the aim of an insane");
		if(type==4)System.out.println("Aim Boost      : all the troops in the room will have the aim of someone in alert but will be temp shocked until after the peek round");
		if(type==5)System.out.println("Warrior        : troops dont get wounded or insane in 1v1s; their aim is the same as a shocked player would be ");
		if(type==6)System.out.println("Lone Wolf      : if there is a man on each corner the lone troop will automatically be focused and the others will be alert");
		if(type==7)System.out.println("Lucky Bastard  : during 1v1 situations where your aim is equivalent to the enemy's aim then you will automatically win the fight but you will be wounded ");
		if(type==8)System.out.println("InsaneInsanity : if a troop is charged and flash they will go insane but wont friendly fire and will get the aim of a shocked player");		
	}
	public void perkEffects(int selection,Troop troop){
		if(selection==1){
			inUse=1;
			if(troop.position==1||troop.position==2||troop.position==3||troop.position==4){
				troop.clearMentalState();
				troop.alert=1;
				troop.mentalChanges();
			}
		}
		if(selection==2){
			inUse=1;
			//if()
		}
	}
}
