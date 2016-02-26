package scaleproblem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScaleTest {

	@Test
	public void findHeaviestItem() {
		List<Ball> balls = new ArrayList<>();
		balls.add(new Ball("1", 10));
		balls.add(new Ball("2", 10));
		balls.add(new Ball("3", 10));
		balls.add(new Ball("4", 10));
		balls.add(new Ball("5", 10));
		balls.add(new Ball("6", 20));
		balls.add(new Ball("7", 10));
		balls.add(new Ball("8", 10));
		assertTrue(Scale.getHeaviest(balls).getDescription().equals("6"));
	}

	@Test
	public void weigh() {
		List<Ball> balls = new ArrayList<>();
		balls.add(new Ball("1", 10));
		balls.add(new Ball("2", 10));
		balls.add(new Ball("3", 10));
		assertTrue(Scale.weigh(balls) == 30);

	}

}
