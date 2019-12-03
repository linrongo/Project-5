# Project-5

	I. MesoStationInfos
		1. StationList -  a HashMap<String,Integer> of all stations ID as keys and their letter average as value
		2. MesoStationInfo() - get readFile() value and ut that onto StationList
 		3. readFile() - read Meonet.txt and put their stid and letter average into a HashMap, return that HashMap
 		4. addStation(String stid) - uppercase stid and add it to the StationList along with its letter average
 		5. calAvg(String stid) - calculate letter Average of the stid
 		6. getStationList - sort, read and put all keys of StationList into a ArrayList<String> and return that
 		7. toString() -  return a string with StationList keys and values
	
	II. HammingDist extends MesoStationInfos
		1. hammingDistList - a HashMap<String,Integer> of stations ID and theie hamming distance from an station
		2. HammingDist() - call MesoStationInfo() and create hammingDistList as a new HashMap
		3. setHammingList(String input) - calculate Hamming distace from input to all stids from StationList and put their stid and Hamming Distance into hammingDistList
		4. getHammingDist(String input, String stid) -  return an Integer of the hamming distance between the input and stid
		5. getsameDist(int dist) - return a String of all stations from hammingDistList with the same value as dist
		6. sameDist() - return an int[] of the number of stations with the same distance
		
	III. Main
		1. 
