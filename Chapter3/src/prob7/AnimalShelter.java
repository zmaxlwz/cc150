package prob7;

//3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. 
//People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, 
//or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). 
//They cannot select which specific animal they would like. 
//Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
//You may use the built-in LinkedList data structure. 

import java.util.*;

public class AnimalShelter {
	//use two queues, one queue is the real animal object, the other is empty
	//enqueue:  enqueue to the non-empty queue, or if both are empty, enqueue to any one
	//dequeueAny:  dequeue the first animal from the non-empty queue
	//dequeueDog:  if peek the first element is dog, dequeue it, otherwise, dequeue cats and enqueue into the empty queue, 
	//				dequeue the first dog, and move the rest into the second queue
	//dequeueCat:  same as dequeueDog
	
	//queue1 is non-empty
	LinkedList<Animal> queue1;
	//queue2 is empty
	LinkedList<Animal> queue2;
		
	public AnimalShelter(){
		queue1 = new LinkedList<Animal>();
		queue2 = new LinkedList<Animal>();
	}	
	
	public void enqueue(Animal animal){
		
		queue1.offer(animal);
		
	}
	
	public Animal dequeueAny(){
		if(!queue1.isEmpty()){
			return queue1.poll();
		}
		else{
			return null;
		}
		
	}
	
	public Animal dequeueDog(){
		Animal animal = queue1.peek();
		String type = "dog";
		while(animal != null && !animal.type.equals(type)){
			queue2.offer(queue1.poll());
			animal = queue1.peek();
		}
		if(animal == null){
			queue1 = queue2;
			queue2 = new LinkedList<Animal>();
			return null;
		}
		//find the first dog
		animal = queue1.poll();
		while(!queue1.isEmpty()){
			queue2.offer(queue1.poll());
		}
		queue1 = queue2;
		queue2 = new LinkedList<Animal>();
		return animal;
	}
	
	public Animal dequeueCat(){
		Animal animal = queue1.peek();
		String type = "cat";
		while(animal != null && !animal.type.equals(type)){
			queue2.offer(queue1.poll());
			animal = queue1.peek();
		}
		if(animal == null){
			queue1 = queue2;
			queue2 = new LinkedList<Animal>();
			return null;
		}
		//find the first cat
		animal = queue1.poll();
		while(!queue1.isEmpty()){
			queue2.offer(queue1.poll());
		}
		queue1 = queue2;
		queue2 = new LinkedList<Animal>();
		return animal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Animal("cat", "cat1"));
		shelter.enqueue(new Animal("dog", "dog1"));
		shelter.enqueue(new Animal("cat", "cat2"));
		shelter.enqueue(new Animal("dog", "dog2"));
		
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueCat().name);
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueDog().name);
		
	}

}

class Animal{
	String type;
	String name;
	public Animal(String type, String name){
		this.type = type;
		this.name = name;
	}
	
}


