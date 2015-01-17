package summerProject;

public class GravityCalculator {

	public static void main(String[] args) {
		double gravity = -9.81;
		double initalVelocity = 0.0;
		double fallingTime = 10.0;
		double initialPosition = 0.0;
		double finalPosition = 0.0;

		finalPosition = (0.5) * (gravity) * (fallingTime * fallingTime);
		
		System.out.println("The object's position after " + fallingTime + " seconds is " + finalPosition + "m");
	}

}

//original output is 0m in 10sec