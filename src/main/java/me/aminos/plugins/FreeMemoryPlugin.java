package me.aminos.plugins;

import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.ScraperContext;
import org.webharvest.runtime.processors.WebHarvestPlugin;
import org.webharvest.runtime.variables.EmptyVariable;
import org.webharvest.runtime.variables.Variable;

public class FreeMemoryPlugin extends WebHarvestPlugin {

	private static final String NAME = "free-memory";

	private static final String[] VALID_ATTRIBUTES = new String[] {};
	private static final String[] REQUIRED_ATTRIBUTES = new String[] {};

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String[] getValidAttributes() {
		return VALID_ATTRIBUTES;
	}

	@Override
	public String[] getRequiredAttributes() {
		return REQUIRED_ATTRIBUTES;
	}

	@Override
	public Variable executePlugin(Scraper scraper, ScraperContext context) {

		System.out.println("Garbage Collector");
		int totalMemory = (int) (Runtime.getRuntime().totalMemory() / (1024 * 1024));
		System.out.println(totalMemory - Runtime.getRuntime().freeMemory()
				/ (1024 * 1024) + "/" + totalMemory);
		System.gc();
		System.gc();
		System.gc();
		System.out.println(totalMemory - Runtime.getRuntime().freeMemory()
				/ (1024 * 1024) + "/" + totalMemory);

		//
		return new EmptyVariable();
	}
}
