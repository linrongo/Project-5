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
		0. Label enterDistace - "Enter Distance:" label
		1. TextField distanceInput - read result from the slider
		2. Button showStation - when pressed show all stations with the chosen distance from the slider
		3. Slider distanceSlider -  choose the hamming distance from 1 to 4
		4. TextArea stationList - display ShowStation button result
		5. Label compare - "Compare With" label
		6. ComboBox<String> stid - ComboBox of all Stid as options
		7. Button calculateHD - When pressed, shows number of stations with the same distance
		8. Label dist0 - "Distance 0" label
		9. Label dist1 - "Distance 1" label
		10. Label dist2 - "Distance 2" label
		11. Label dist3 - "Distance 3" label
		12. Label dist4 - "Distance 4" label
		13. TextField HDresult0 - display how many station with hamming distance of 0
		14. TextField HDresult1 - display how many station with hamming distance of 1
		15. TextField HDresult2 - display how many station with hamming distance of 2
		16. TextField HDresult3 - display how many station with hamming distance of 3
		17. TextField HDresult4 - display how many station with hamming distance of 4
		18. Button addStation - when pressed add the station ID from the stationInput TextField
		19. TextField stationInput - editable TextField to write station ID what need to be added
		20. TextArea stationLetterAvg - display Stations IDand their letter averages
		21. Label bonus - "List of all stations and their letter average" label
		22. Button extra - When pressed, change the scene to the Bonus Scene
		23. Button back -  when pressed, goes bach to the first Scene
