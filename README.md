# Project-5

	I. MesoStationInfos
		1. StationList -  a HashMap<String,Integer> of all stations ID as keys and their letter average as value
		2. MesoStationInfo() - get readFile() value and ut that onto StationList
 		3. readFile() - read Meonet.txt and put their stid and letter average into a HashMap, return that HashMap
 		4. addStation(String stid) - uppercase stid and add it to the StationList along with its letter average
 		5. calAvg(String stid) - calculate letter Average of the stid
 		6. getStationList - sort, read and put all keys of StationList into a ArrayList<String> and return that
 		7. toString() -  return a string with StationList keys and values
	
	II. HammingDist
		1. hammingDistList - a HashMap<String,Integer> of stations ID
