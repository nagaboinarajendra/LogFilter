package com.logfilter;

import java.io.*;

public class Temp1 {
	public void convert(String pathOfFile, String resultsFileName,String start,String end) throws IOException {
	    File inputFile = new File(pathOfFile);
		
		String myDir = inputFile.getParent();
	    File tempFile = new File(myDir +"\\"+resultsFileName+".txt");
	    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));

	    String lineToRemove = start;
	    String currentLine;
	    while((currentLine = reader.readLine()) != null) {
	        // trim newline when comparing with lineToRemove
	       // String trimmedLine = currentLine.trim();
	        if(currentLine.startsWith(lineToRemove)) {
	        	writer.write(currentLine);
	        	System.out.println(currentLine);
	        	while((currentLine = reader.readLine()) != null && !currentLine.trim().startsWith(end)){
		        	System.out.println(currentLine);
	        		writer.write(currentLine + System.getProperty("line.separator"));
	        	}
	        	break;
	        }
	        else {
	        	continue;
	        }
	    }
	    writer.close();
	    reader.close();
	    boolean successful = tempFile.renameTo(inputFile);
	    System.out.println(successful);

	}
	
}

