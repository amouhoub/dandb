package me.aminos.dandb.sample;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.webharvest.definition.DefinitionResolver;
import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.runtime.Scraper;
import org.xml.sax.InputSource;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {

		// register external plugins if there are any
		DefinitionResolver.registerPlugin("me.aminos.plugins.LogPlugin");
		DefinitionResolver.registerPlugin("me.aminos.plugins.FreeMemoryPlugin");

		InputSource is = new InputSource(
				Sample.class.getResourceAsStream("dandb.xml"));
		ScraperConfiguration config = new ScraperConfiguration(is);
		Scraper scraper = new Scraper(config, "");

		if (args.length == 7) {
			scraper.addVariableToContext("outputPath", args[0]);
			scraper.addVariableToContext("lastTop", args[1]);
			scraper.addVariableToContext("last1st", args[2]);
			scraper.addVariableToContext("last2nd", args[3]);
			scraper.addVariableToContext("last3rd", args[4]);
			scraper.addVariableToContext("lastPage", args[5]);
			scraper.addVariableToContext("pageCount", args[6]);
		} else {
			scraper.addVariableToContext("outputPath",
					"/Users/aminos/Desktop/dandb");
			scraper.addVariableToContext("lastTop", 1);// 1
			scraper.addVariableToContext("last1st", 1);// 1
			scraper.addVariableToContext("last2nd", 5);// 5
			scraper.addVariableToContext("last3rd", 1);// 1
			scraper.addVariableToContext("lastPage", 423);// 423
			scraper.addVariableToContext("pageCount", 426);// 426
		}

		scraper.setDebug(true);

		scraper.execute();

		// do something with articles...

	}
}