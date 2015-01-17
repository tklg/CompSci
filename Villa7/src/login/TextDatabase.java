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

public class TextDatabase {
	
	BufferedReader input;
    Writer output;
    Print p = new Print();
    File dir, dataFile, tempFile;
    static String divider = " ||| ";
    
	public TextDatabase(String dirName, String fileName, String tempFileName) {
		dir = new File (this.getClass().getClassLoader().getResource("").getPath() + dirName);
		createDir(dir);
		dataFile = new File(dir, fileName);
	    tempFile = new File(dir, tempFileName);
	    createFile(dataFile);
	    createFile(tempFile);
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
    public ArrayList<String> readFile() {
    	String line;
        ArrayList<String> result = new ArrayList<String>();
    	try {
            input = new BufferedReader(new FileReader(dataFile));
            while ((line = input.readLine()) != null) {
                result.add(line);
            }
            input.close();
            //p.nl("File \"" + dataFile.toString() + "\" read read and closed.");
            return result;
        }
        catch (FileNotFoundException e) {
            p.ne("File not found: " + e.toString());
            result.add("Error: FileNotFoundException " + e.toString());
            return result;
        } catch (IOException e) {
            p.ne("Can not read file: " + e.toString());
            result.add("Error: IOException " + e.toString());
            return result;
        }
    }
    public boolean removeLineFromFile(String line) {
    	if (checkFile(dataFile, true) == 0) {
    		createFile(tempFile);
    		if (checkFile(tempFile, true) == 0) {
    			try {
                    BufferedReader input;
                    input = new BufferedReader(new FileReader(dataFile));

                    String receiveString;
                    BufferedWriter output;
                    output = new BufferedWriter(new FileWriter(tempFile, true));
                    while ((receiveString = input.readLine()) != null ) {
                        if (!receiveString.equals(line)) {
                            output.write(receiveString + "\n");
                        }
                    }
                    output.close();
                    input.close();
	               /*Delete the original file*/
	                try {
	                    dataFile.delete();
	                } catch (Exception e) {
	                    p.ne("Could not delete file: " + e);
	                }
	                /*ename the new file to the filename the original file had.*/
	                try {
	                    tempFile.renameTo(dataFile);
	                } catch (Exception e) {
	                    p.ne("Could not rename file: " + e);
	                }
	                return true;
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                p.ne("File not found: " + e.toString());
	            } catch (IOException e) {
	            	p.ne("Can not read file: " + e.toString());
	                e.printStackTrace();
	            }
        	} else {
        		p.ne("removeLineFromFile failed: tempFile does not exist and may have been created");
        	}
    	} else {
    		p.ne("removeLineFromFile failed: file does not exist and may have been created");
    	}
    	return false;
    }
    public boolean removeLineFromFile(int line) {
    	if (checkFile(dataFile, true) == 0) {
    		createFile(tempFile);
    		if (checkFile(tempFile, true) == 0) {
    			try {
                    BufferedReader input;
                    input = new BufferedReader(new FileReader(dataFile));

                    String receiveString;
                    BufferedWriter output;
                    output = new BufferedWriter(new FileWriter(tempFile, true));
                    int i = 0;
                    while ((receiveString = input.readLine()) != null ) {
                        if (i != line) {
                            output.write(receiveString + "\n");
                        }
                        i++;
                    }
                    output.close();
                    input.close();
	               /*Delete the original file*/
	                try {
	                    dataFile.delete();
	                } catch (Exception e) {
	                    p.ne("Could not delete file: " + e);
	                }
	                /*ename the new file to the filename the original file had.*/
	                try {
	                    tempFile.renameTo(dataFile);
	                } catch (Exception e) {
	                    p.ne("Could not rename file: " + e);
	                }
	                return true;
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                p.ne("File not found: " + e.toString());
	            } catch (IOException e) {
	            	p.ne("Can not read file: " + e.toString());
	                e.printStackTrace();
	            }
        	} else {
        		p.ne("RemoveLineFromFile failed: tempFile does not exist and may have been created");
        	}
    	} else {
    		p.ne("RemoveLineFromFile failed: file does not exist and may have been created");
    	}
    	return false;
    }
    public void writeFile(String lineToWrite, boolean newLine, boolean div) {
    	if (checkFile(dataFile, true) == 0) {
    		try {
                output = new BufferedWriter(new FileWriter(dataFile, true));
                if (newLine) {
                	output.write("\n");
                }
                if (div) {
                	output.write(divider);
                }
                output.write(lineToWrite);
                output.close();
                p.nl("\"" + lineToWrite + "\" added to " + dataFile);
            }
            catch (IOException e) {
                p.ne("File write failed: " + e);
            }
    	} else {
    		p.ne("writeFile failed: file does not exist and may have been created");
    	}
    }
    /*private String addSpace(int num) {
    	String ret = "";
    	for (int i = 0; i < num; i++) {
    		ret += " ";
    	}
    	return ret;
    }*/
}
