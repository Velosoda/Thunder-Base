public class Room {
	int topRight=0;		//1
	int topLeft=0;		//2
	int bottomLeft=0;	//3
	int bottomRight=0;	//4
	int window1Top=0;	//5
	int window1Bottom=0;//6
	int window2Top=0;	//7
	int window2Bottom=0;//8
	int doorLeft=0;		//9
	int doorRight=0;	//10
	int mid=0;			//11
	int positionsLeftOfY=5;
	int positionsRightofY=5;
	
	public int cornerCount(){
		return topRight+topLeft+bottomRight+bottomLeft;
	}
	public boolean someoneWindow(){
		if(window1Top+window1Bottom+window2Top+window2Bottom!=0)return true;
		else return false;
	}
	//tells you whether there is someone positioned at the door
	public boolean someoneDoor(){
		if(doorLeft+doorRight!=0)return true;
		else return false;
	}
	//counts how many people there are in the left side of the y axis
	public int leftYCount(){
		int leftY =topLeft+window1Top+window1Bottom+bottomLeft+doorLeft;
		return leftY;
	}
	//counts how many people there are in the right side of the y axis 
	public int rightYCount(){
		int rightY=topRight+window1Top+window2Bottom+bottomRight+doorRight;
		return rightY;
	}
	//counts how many people there are in the lower x axis 
	public int lowerXCount(){
		int lowerX=bottomLeft+bottomRight+window1Bottom+window2Bottom+doorLeft+doorRight;
		return lowerX;
	}
	
}
