/*
 * TextDatabase.java
 * Creates a text file that can be used as a very small database
 * (c) Theodore Kluge 2015 - http://kluge.ninja
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import functions.*;

public class QueryDatabase {
	//TODO: write a single function that receives an SQL-like query
	
	BufferedReader input;
    Writer output;
    Print p = new Print();
    File dir, dataFile, tempFile;
    static String divider = " ||| ";
    ArrayList<String> row = new ArrayList<String>();
    ArrayList<String> col = new ArrayList<String>();
    ArrayList<String> fileContents = new ArrayList<String>();
    //String row[];
    
	public QueryDatabase(String dirName, String fileName, String tempFileName) {
		dir = new File (this.getClass().getClassLoader().getResource("").getPath() + dirName);
		createDir(dir);
		dataFile = new File(dir, fileName);
	    tempFile = new File(dir, tempFileName);
	    createFile(dataFile);
	    createFile(tempFile);
	}
	public void query(String query) {
		String q[] = query.split(" ");
		p.nl("Recieved query: \"" + query + "\"");
		switch (q[0]) { //reads the first word of the query
			case "SELECT": 
				select(q);
				break;
			case "UPDATE": 
				break;
			case "CREATE": 
				break;
			case "INSERT": 
				break;
			default: 
				p.ne("Recieved invalid query. (" + query + ")");
				break;
		}
	}
	//SELECT * FROM TABLE WHERE HEADER = 'VALUE'
	//  0    1   2    3     4     5    6    7
	/*
	 * select - recieves a SELECT FROM query string as an array,
	 * opens and reads the requested file (table) into an arraylist,
	 * then selects everything in a row and makes an arraylist from those
	 * then either returns a single value from column or returns the entire row
	 */
	public String[] select(String[] q) {
		if (q[2].equals("FROM")) {
			dataFile = new File(dir, q[3]);
			fileContents = readFile();
			if (q[4].equals("WHERE")) {
				int i = 0;
				for (String line : fileContents) {
					row.add(line);
					i++;
				}
				if (q[1].equals("*")) { //return everything
					return row;
				} else { //return a single value
					String potato[] = {""};
					String valToRet = row[Integer.parseInt(q[1])];
					potato[0] = valToRet;
					return potato;
				}
			}
		}
		return q;
	}
	public ArrayList<String> readFile() {
    	String line;
        ArrayList<String> result = new ArrayList<String>();
    	try {
            input = new BufferedReader(new FileReader(dataFile));
            while ((line = input.readLine()) != null) {
                result.add(line);
            }
            input.close();
            return result;
        }
        catch (FileNotFoundException e) {
            p.ne("File not found: " + e);
            result.add("Error: FileNotFoundException " + e);
            return result;
        } catch (IOException e) {
            p.ne("Can not read file: " + e);
            result.add("Error: IOException " + e);
            return result;
        }
    }
	private int createDir(File dir) {
		if (!dir.exists()) {
			try {
				dir.mkdirs();
				return 0;
			} catch (Exception e) {
				p.ne("Directory creation failed. Error: " + e);
				return 2;
			}
		} else {
			return 1;
		}
	}
	private int createFile(File file) {
		if (!file.exists()) {
			p.nl("Creating file: " + file);
			try {
				file.createNewFile();
				return 2; //2: file created
			} catch (IOException e) {
				p.ne("File creation failed. Error: " + e);
				return 3; //Error code 3: file creation failed
			}
		} else {
			//p.ne("File \"" + file + "\" already exists.");
			return 3;
		}
	}
    private int checkFile(File file, boolean create) {
    	if (!file.exists()) {
    		p.ne("File \"" + file.toString() + "\" does not exist.");
    		if (create) {
    			return createFile(file);
    		} else {
    			return 1; //1: file doesnt exist, not creating new
    		}
    	}
    	return 0; //0: file exists
    }
}
