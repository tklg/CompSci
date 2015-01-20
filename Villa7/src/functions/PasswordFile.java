package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordFile {

	//File root = android.os.Environment.getExternalStorageDirectory();
    File dir = new File ("/passwordhash");

    File inFile = new File(dir, "config.txt");
    File tempFile = new File(dir, "configTemp.txt");
	
}
