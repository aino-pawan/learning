package com.pawan.learning_app;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

	@Test
	public void testMainOutput() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		PrintStream originalOut = System.out;

		System.setOut(printStream);

		try {
			App.main(new String[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.setOut(originalOut);

		String output = outputStream.toString().trim();

		assertEquals("Hello World!", output);
	}
}