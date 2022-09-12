package com.websearchengine.org;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.*;

public class HTMLtoText{

	public static void textFileCreator(String fileName) throws IOException {

		File myfile = new File("/Users/harshavardhannaidugangavarapu/Desktop/ACC-WebSearchEngine-riaz/html-files/" + fileName);
		org.jsoup.nodes.Document document = Jsoup.parse(myfile, "UTF-8");
		String string = document.text();
		String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
		PrintWriter out = new PrintWriter("/Users/harshavardhannaidugangavarapu/Desktop/ACC-WebSearchEngine-riaz/text-files/" + fileNameWithOutExt + ".txt");
		out.println(string);
		out.close();
	}
	
	public static void generateTextFiles() throws IOException {
		File folder = new File("/Users/harshavardhannaidugangavarapu/Desktop/ACC-WebSearchEngine-riaz/html-files");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				textFileCreator(listOfFiles[i].getName());
			}
		}
		System.out.println("Text files generated.");
	}

	public static void main(String[] args) throws IOException {
		generateTextFiles();
	}
}
