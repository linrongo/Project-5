package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoStationInfos {
	protected HashMap<String, Integer> stationList;
	
	public MesoStationInfos() throws IOException {
		stationList = readFile();
	}

	private HashMap<String, Integer> readFile() throws IOException {
		HashMap<String,Integer> stationList = new HashMap<String,Integer>();
		
		BufferedReader profile = new BufferedReader(new FileReader("Mesonet.txt"));
       	String line;       	
      
		line = profile.readLine();
	    while ( line != null) {    	
	      // Trim
	    	line = line.trim();   	
	      // Add it to the HashMap of stationList
	       		stationList.put(line, calAvg(line));
       		
	      line = profile.readLine();
       }    
	    profile.close();
	    return stationList;
	}

	public void addStation(String stid) {
		String input = stid.toUpperCase();
		stationList.put(input, calAvg(input));
	}

	private Integer calAvg(String stid) {
		int asciiTot = 0; 
		int length = stid.length();
		// get total value
			for(int i = 0; i < length; ++i) {
				asciiTot += (int)stid.charAt(i);
			}
		// divide total by length of stid
			double asciiAve = asciiTot/length;
			int avg = 0;
			
		// get average from ceiling of the diffence is >= .5
			if((asciiAve - Math.floor(asciiAve )) < 0.5) {
			 avg =  (int) Math.floor(asciiAve);
			}
			
		// otherwise get average from floor value
			else avg = (int) Math.ceil(asciiAve);

			return avg;
	}

	public ArrayList<String> getStationList() {
		ArrayList<String> result = new ArrayList<String>();
		// sort by key using TreeMap
				TreeMap<String,Integer> sort = new TreeMap<String,Integer>(stationList); 
			// add it to the return string
		        for (Map.Entry<String,Integer> entry : sort.entrySet())  
		            result.add(entry.getKey());
				return result; 	
			}

	public String toString() {
		String result = "";
		// sort by key using TreeMap
		TreeMap<String,Integer> sort = new TreeMap<String,Integer>(stationList); 
	// add it to the return string
        for (Map.Entry<String,Integer> entry : sort.entrySet())  
            result += entry.getKey() + "   :   " + entry.getValue() + "\n"; 

		return result;
	}

}
