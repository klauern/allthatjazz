package klauer.dropwizard;

import klauer.dropwizard.health.TemplateHealthCheck;
import klauer.dropwizard.resources.HelloWorldResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.servlets.AssetServlet;

public class HelloWorldService extends Service<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	private HelloWorldService() {
		super("hello-world");
	}

	@Override
	protected void initialize(HelloWorldConfiguration configuration,
			Environment environment) throws Exception {
		final String template = configuration.getTemplate();
		final String defaultName = configuration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addHealthCheck(new TemplateHealthCheck(template));
		
		final AssetsBundle assets = new AssetsBundle("/assets", 0, "/");
//		final AssetsBundle assets = new AssetsBundle("/assets", "/"); // For production
		
		assets.initialize(environment);
	}
}