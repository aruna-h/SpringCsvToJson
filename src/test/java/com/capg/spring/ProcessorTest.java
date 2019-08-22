package com.capg.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chilaksh
 *
 *         Junit Test Case
 */
@RunWith(SpringRunner.class)

@SpringBootTest

public class ProcessorTest {

	@InjectMocks
	Processor processor;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);

	}

	String filePath = null;

	/**
	 * @throws Exception
	 */
	@Test
	public void testProcessor() throws Exception {

		String jsonInString = "[ {\r\n" + "  \"ID\" : \"1001\",\r\n" + "  \"fileName\" : \"File1\",\r\n"
				+ "  \"Type\" : \"PDF\",\r\n" + "  \"Direction\" : \"Out\",\r\n" + "  \"Date\" : \"20180518 \"\r\n"
				+ "}, {\r\n" + "  \"ID\" : \"1002\",\r\n" + "  \"fileName\" : \"File2\",\r\n"
				+ "  \"Type\" : \"DOC\",\r\n" + "  \"Direction\" : \"Out\",\r\n" + "  \"Date\" : \"20180502\"\r\n"
				+ "} ]";

		assertEquals(jsonInString,
				processor.transform("springcsvtojson\\blob\\master\\source\\input.csv"));

	}

}
