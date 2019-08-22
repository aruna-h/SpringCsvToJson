package com.capg.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author chilaksh
 * 
 * Processor class to transform a csv data to json
 * 
 */
@Component
public class Processor {

	/**
	 * 
	 * @param filePath
	 * @return json in String is a kind of String object.
	 * @throws IOException
	 * 
	 */
	@Transformer
	public String transform(String filePath) throws IOException {

		String content = new String(Files.readAllBytes(Paths.get(filePath)));

		CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
		CsvMapper csvMapper = new CsvMapper();

		List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(content).readAll();

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll);
		return jsonInString;

	}

}