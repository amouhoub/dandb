package me.aminos.dandb.sample;

import java.io.File;
import java.io.FileNotFoundException;

import org.webharvest.definition.DefinitionResolver;
import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.runtime.Scraper;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File(Sample.class.getResource("dandb.xml").getPath());

		// register external plugins if there are any
		DefinitionResolver.registerPlugin("me.aminos.plugins.LogPlugin");

		ScraperConfiguration config = new ScraperConfiguration(
				file.getAbsolutePath());
		Scraper scraper = new Scraper(config, "/Users/aminos/Desktop/dandb");

		scraper.addVariableToContext("outputPath", "C:/Users/Aminos/Desktop/dandb");

		scraper.setDebug(true);

		scraper.execute();

		// do something with articles...

	}
}