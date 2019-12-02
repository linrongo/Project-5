package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HammingDist extends MesoStationInfos{

	private HashMap<String,Integer> hammingDistList;
	public HammingDist() throws IOException {
		super();
		hammingDistList = new HashMap<String,Integer>();
	}
	
	public Integer getHammingDist(String input, String stid) {
		Integer distance = 0;
	// Compare the letters and if they're not the same then hamming distance increase by 1
			for(int j = 0; j < input.length(); ++j) {
				if (input.charAt(j) != stid.charAt(j)) {
					distance++;
				}
			}		
		return distance;
	}
	
	public void setHammingList(String input) {
		for (Map.Entry<String,Integer> entry : stationList.entrySet())  {
			hammingDistList.put(entry.getKey(),getHammingDist(input,entry.getKey()));
		}
	}
	
	public String getsameDist(int dist) {
		String result = "";
		TreeMap<String,Integer> sort = new TreeMap<String,Integer>(hammingDistList); 

		for (Map.Entry<String,Integer> entry : sort.entrySet())  {
			if (entry.getValue() == dist)
				result = result + entry.getKey() + "\n";
		}		
		return result;
	}
	
	// array of the number of stations with certain distance away
	public int[] sameDist() {
	// biggest distance = 4 so size = 5 (0,1,2,3,4)
		int size = 5;
		int[] list = new int[size];
		int count = 0;
		for(int i = 0; i< list.length; ++i) {
			for (Map.Entry<String,Integer> entry : hammingDistList.entrySet())  {
				if(entry.getValue() == i) count ++;
			}
			 list[i] = count;
			 count = 0;			
		}
		return list;		
	}
	
}
