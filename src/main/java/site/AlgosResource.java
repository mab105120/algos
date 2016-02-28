package site;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bourjm.algos.AlgoPerformance;

import beans.SortingAlgorithm;
import beans.User;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;

@Path("/algos")
public class AlgosResource {

	AlgosConfiguration config = new AlgosConfiguration();

	public AlgosResource(AlgosConfiguration config) {
		this.config = config;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		return config.getUser();
	}

	@GET
	@Path("/measure/{algorithm}/{size}")
	public double measureAlgorithmPerformance(@PathParam("algorithm") SortingAlgorithm alogrithm,
			@PathParam("size") int size) {
		Double[] d = new Double[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++)
			d[i] = rand.nextDouble();
		switch (alogrithm) {
		case SELECTION:
			return AlgoPerformance.measurePerformance(d, SelectionSort::sort);
		case INSERTION:
			return AlgoPerformance.measurePerformance(d, InsertionSort::sort);
		case MERGE:
			return AlgoPerformance.measurePerformance(d, MergeSort::sort);
		case QUICK:
			return AlgoPerformance.measurePerformance(d, QuickSort::sort);
		default:
			throw new IllegalArgumentException("Unkown algo!");
		}
	}

	@GET
	@Path("/measure/queryparam")
	public String blah(@QueryParam("algorithm") SortingAlgorithm alogrithm,
			@QueryParam("size") int size) {
		return alogrithm + ": " + size;
	}

}
