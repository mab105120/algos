package scaleproblem;

public class Ball implements Weighable {

	private final String description; 
	private final double weight;
	
	public Ball(String description, double weight) { 
		this.description = description;
		this.weight = weight;
	}
	
	public String getDescription() { 
		return this.description;
	}
	
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

}
