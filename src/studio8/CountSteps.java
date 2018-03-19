package studio8;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CountSteps {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<Double> xG = new ArrayList<Double>();
		List<Double> yG = new ArrayList<Double>();
		List<Double> zG = new ArrayList<Double>();
		
		String fileName = "data/test.csv";
		
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			
			inputStream.useDelimiter(",");
			
			int itemCount = 0;
			
			while(inputStream.hasNext()) {
				String line = inputStream.next();
				if((itemCount % 3) == 0) {
					// x
					xG.add(Double.parseDouble(line));
				}
				else if((itemCount % 3) == 1) {
					// y
					yG.add(Double.parseDouble(line));
				}
				else {
					// z
					zG.add(Double.parseDouble(line));
				}
				itemCount++;
				
				System.out.print(line + " | ");
				System.out.println("");
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}