package com.anfelisa.importer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;

public class Importer {

	public static void main(String[] args) {
		try {

			Reader fileReader = new FileReader("voc.csv");
			CSVReader reader = new CSVReader(fileReader, ';');

			String[] nextLine;
			List<String> nextGiven = new ArrayList<>();
			List<String> nextWanted = new ArrayList<>();
			int index = 1;
			while ((nextLine = reader.readNext()) != null) {
				System.out.println(nextLine[0] + " - "+ nextLine[1] );
				if (!nextLine[0].startsWith("Elementarwortschatz") && !nextLine[0].startsWith("Grundwortschatz") && StringUtils.isNotBlank(nextLine[0])) {
					String given = nextLine[0]; 
					if (StringUtils.endsWith(given, " v")) {
						given = given.substring(0, given.length() - 1);
						given += "(verb)";
					}
					if (StringUtils.endsWith(given, " n")) {
						given = given.substring(0, given.length() - 1);
						given += "(noun)";
					}
					if (StringUtils.endsWith(given, " adv")) {
						given = given.substring(0, given.length() - 3);
						given += "(adverb)";
					}
					if (StringUtils.endsWith(given, " adj")) {
						given = given.substring(0, given.length() - 3);
						given += "(adjective)";
					}
					nextGiven.add(given);
					String wanted = nextLine[1]; 
					if (StringUtils.endsWith(wanted, " v")) {
						wanted = wanted.substring(0, wanted.length() - 1);
						wanted += "(Verb)";
					}
					if (StringUtils.endsWith(wanted, " n")) {
						wanted = wanted.substring(0, wanted.length() - 1);
						wanted += "(Nomen)";
					}
					if (StringUtils.endsWith(wanted, " adv")) {
						wanted = wanted.substring(0, wanted.length() - 3);
						wanted += "(Adverb)";
					}
					if (StringUtils.endsWith(wanted, " adj")) {
						wanted = wanted.substring(0, wanted.length() - 3);
						wanted += "(Adjektiv)";
					}
					nextWanted.add(wanted);
				}
				if (nextGiven.size() == 8) {
					writeTest(index, nextGiven, nextWanted);
					nextGiven.clear();
					nextWanted.clear();
					index++;
				}
			}
			if (nextGiven.size() > 0) {
				writeTest(index, nextGiven, nextWanted);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeTest(int index, List<String> nextGiven,	List<String> nextWanted) throws FileNotFoundException {
		String testName = "G " + index;
		String fileName = StringUtils.leftPad(index + "", 2, "0") + "_" + testName + ".anfelisa";
		PrintWriter writer = new PrintWriter(fileName);
		writer.println("vocabularyTest \"" + testName+ "\" {");
		for (int i = 0; i < nextGiven.size(); i++) {
			String given = nextGiven.get(i);
			String wanted = nextWanted.get(i);
			writer.println("   \"" + given + "\" \"" + wanted + "\"");
		}
		writer.println("}");
		writer.close();
	}

}

