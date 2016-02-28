package site;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class AlgosApplication extends Application<AlgosConfiguration> {

	public static void main(String[] args) throws Exception {
		new AlgosApplication().run(args);
	}

	@Override
	public void run(AlgosConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub
		AlgosResource resource = new AlgosResource(configuration);
		environment.jersey().register(resource);

	}

}
