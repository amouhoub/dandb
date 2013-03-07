package me.aminos.plugins;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.ScraperContext;
import org.webharvest.runtime.processors.WebHarvestPlugin;
import org.webharvest.runtime.variables.EmptyVariable;
import org.webharvest.runtime.variables.Variable;

public class LogPlugin extends WebHarvestPlugin {

	private static final Log LOG = LogFactory.getLog(LogPlugin.class);

	private static final String NAME = "log";

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

		final String _message = this.executeBody(scraper, context).toString();
		//
		// LOG.info(" >> " + _message);
		System.out.println(_message);
		//
		return new EmptyVariable();
	}
}
