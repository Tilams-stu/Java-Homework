package cn.edu.nankai.Tilams.Homework1;

public class Bicycle extends Cycle{
	public void quick(){
		System.out.println(" bicyclequick");
	}
	public static void main(String[] args) {
		Cycle bicycle = new Bicycle();
		bicycle.ride();
		
	}
}
