package stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static void stackInterface(){
		Scanner in =new Scanner(System.in);
		Stack myStack=new Stack();
		boolean quit=false;
		while(!quit){
			System.out.println("What would you like to do?"
					+ "\n1. Print the stack"
					+ "\n2. Add an item to the stack"
					+ "\n3. Remove an item from the stack"
					+ "\n4. Quit");
			
			try{
			int choice=Integer.parseInt(in.nextLine());
			switch(choice){
				case(1):
					myStack.outputContents();
					break;
				case(2):
					System.out.println("What is the name of the item?");
					String name=in.nextLine();
					System.out.print("What is the task?");
					String task=in.nextLine();
					myStack.addItem(name, task);
					System.out.println(name+" has been added");
					break;
				case(3):
					Item removed=myStack.removeItem();
					System.out.println(removed.name+ " with the task: "+removed.task+" has been removed");
					break;
				case(4):
					quit=true;
					break;
				default:
					System.out.println("That is not a valid choice");
					break;
			}
			}catch (NumberFormatException ex){
				System.out.println("That is not a valid input, enter the number of your choice");
			}
		}
	}
	static void queueInterface(){
		Scanner in =new Scanner(System.in);
		Queue myQueue=new Queue();
		boolean quit=false;
		while(!quit){
			System.out.println("What would you like to do?"
					+ "\n1. Print the Queue"
					+ "\n2. Add an item to the Queue"
					+ "\n3. Remove an item from the Queue"
					+ "\n4. Quit");
			
			try{
			int choice=Integer.parseInt(in.nextLine());
			switch(choice){
				case(1):
					myQueue.outputContents();
					break;
				case(2):
					System.out.println("What is the name of the item?");
					String name=in.nextLine();
					System.out.print("What is the task?");
					String task=in.nextLine();
					myQueue.addItem(name, task);
					System.out.println(name+" has been added");
					break;
				case(3):
					Item removed=myQueue.removeItem();
					System.out.println(removed.name+ " with the task: "+removed.task+" has been removed");
					break;
				case(4):
					quit=true;
					break;
				default:
					System.out.println("That is not a valid choice");
					break;
			}
			}catch (NumberFormatException ex){
				System.out.println("That is not a valid input, enter the number of your choice");
			}
		}
	}
	

	
	public static void main(String[] args) {
		boolean loop=true;
		while(loop){
		Scanner in =new Scanner(System.in);
		System.out.println("Welcome to Sam's custom queue/stack program!\nWould you like to create a:\n1. Stack\n2. Queue\n3. Quit");
		try{
			int choice=Integer.parseInt(in.nextLine());
			switch(choice){
			case(1):
				stackInterface();
				break;
			case(2):
				queueInterface();
				break;
			case(3):
				loop=false;
				System.out.println("Goodbye! :(");
			default:
				break;
			}
		}catch (NumberFormatException ex){
			System.out.println("That is not a valid input.\nTry again.");
		}
		}
		

	}
}
class Queue{
	ArrayList<Item> items;
	Queue(){
		items=new ArrayList();
	}
	void outputContents(){
		if(items.size()>0){
		for(Item i: items){
			i.printDetails();
		}
		}else{
			System.out.println("The queue is empty!");
		}
		
	}
	Item removeItem(){
		Item i=items.get(0);
		items.remove(0);
		updateRemove();
		return i;
	}
	void updateRemove(){
		for (Item i: items){
			i.place-=1;
		}
	}
	void addItem(String name,String task){
		updateAdd();
		items.add(new Item(name,task));
	}
	void updateAdd(){
		for (Item i: items){
			i.place+=1;
		}
	}
}
class Stack{
	ArrayList<Item> items;
	Stack(){
		items=new ArrayList();
	}
	void outputContents(){
		if(items.size()>0){
		for(Item i: items){
			i.printDetails();
		}
		}else{
			System.out.println("The stack is empty!");
		}
		
	}
	Item removeItem(){
		Item i=items.get(0);
		items.remove(0);
		updateRemove();
		return i;
	}
	void updateRemove(){
		for (Item i: items){
			i.place-=1;
		}
	}
	void addItem(String name,String task){
		updateAdd();
		items.add(0, new Item(name,task));
	}
	void updateAdd(){
		for (Item i: items){
			i.place+=1;
		}
	}

	
}
class Item{
	public String name;
	public String task;
	public int place;
	Item (String n, String t){
		name=n;
		task=t;
		place=0;
	}
	void printDetails(){
		System.out.println("My name is: "+name+"\nMy task is: "+task+"\nAnd I am in position: "+place);
	}
	
	
}

