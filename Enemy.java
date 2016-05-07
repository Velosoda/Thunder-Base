package TBA;
import java.util.ArrayList;
import java.util.Random;
public class Enemy{
	Random r = new Random();

	//The numbers with in these boxes are used to give the Data some form of id 
	//for later use in the program
	//*************************************************************************
	//these two will tell us how many of each type of equipment the enemy has *
	int flashes=0;		//1													  *
	int charges=0;		//2							  						  *
	//*************************************************************************
	
	//these are used to properly randomize setup procedures
	int initApproachRan=4;
	int initEquipRan=2;
	
	//**************************************************
	//these four define what approach the AI will take *
	int windowLeft=0;   		//1					   *
	int windowRight=0;  		//2					   *
	int doorApproach=0;   		//3					   *
	int ceilingApproach=0;		//4					   *
	//**************************************************
	
	int squadMembers=5;
	
	//******************************************************************************
	//These ArrayLists are currently being used to house the enemy troops as well  *
	//as to give the programmer an idea as to which approach the enemy is going to *
	//take																		   *
	ArrayList<Terrorists>leftWindow=new ArrayList<Terrorists>();				 //*
	ArrayList<Terrorists>rightWindow=new ArrayList<Terrorists>();				 //*
	ArrayList<Terrorists>door=new ArrayList<Terrorists>();						 //*
	ArrayList<Terrorists>ceiling=new ArrayList<Terrorists>();					 //*
	//******************************************************************************
	
	//Ai positions will randomly assign a position for the enemy to take 
	public void aiPositions(){
		int approachRan = r.nextInt(initApproachRan)+1;
		
		if(squadMembers>0){
			if(approachRan==1){
				windowLeft=1;
				leftWindow.add(new Terrorists());
				leftWindow.get(0).approach=1;
				squadMembers--;
				initApproachRan=3;
				aiPositions();
			}
			if(approachRan==2){
				windowRight=1;
				rightWindow.add(new Terrorists());
				rightWindow.get(0).approach=2;
				squadMembers--;		
				initApproachRan=3;
				aiPositions();
			}
			if(approachRan==3){
				doorApproach=1;
				door.add(new Terrorists());
				door.get(0).approach=3;
				squadMembers--;
				initApproachRan=3;
				aiPositions();
			}
			
			if(approachRan==4){
				ceilingApproach=1;
				for(int i=0; i<squadMembers; i++){
					ceiling.add(new Terrorists());
				}
				ceiling.get(0).approach=4;
				squadMembers-=5;
				return;
			}
		}
		else return;
	}
	
	//will give the enemies a certain amount of equipment that they can use
	//outcomes are 2flash 0charge or 1flash 1charge
	public void equipmentGet(){
		int equipRan = r.nextInt(initEquipRan)+1;
		if(ceiling.size()==5){
			charges=1;
			return;
		}
		if(flashes+charges<2){
			if(equipRan==1){
				flashes++;
				equipmentGet();
			}
			if(equipRan==2){
				charges=1;
				equipmentGet();
			}
		}
	}
	public void equipmentEquip(int equipmentInventory, int equipmentId, ArrayList<Terrorists> array){
		if(ceiling.size()==5){
			ceiling.get(0).equipment=1;
			charges=0;
			flashes=0;
			return;
		}
		if(equipmentInventory>0){
			if(array.size()>0 && array.get(0).equipment==0){
				array.get(0).equipment=equipmentId;
			}
		}
		else return;
	}
}
