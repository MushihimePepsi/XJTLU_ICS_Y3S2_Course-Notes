import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataLoader {
    Set<CityData> CityDataSet = new HashSet<>();

    public DataLoader(String filePath) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header if exists
            reader.readLine(); // 跳过标题行 "CityA,CityB,Distance"
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // 假设csv逗号分隔
                if (parts.length >= 3) {
                    String city1 = parts[0].trim();
                    String city2 = parts[1].trim();
                    try {
                        Double distance = Double.parseDouble(parts[2].trim());

                        CityData newCityData1;
                        if (findCityData(city1) == null) {
                            newCityData1 = new CityData(city1);
                            CityDataSet.add(newCityData1);
                        } else newCityData1 = findCityData(city1);
                        CityData newCityData2;
                        if (findCityData(city2) == null) {
                            newCityData2 = new CityData(city2);
                            CityDataSet.add(newCityData2);
                        } else newCityData2 = findCityData(city2);

                        newCityData1.addAdjacentDistanceMap(newCityData2, distance);
                    } catch (NumberFormatException e) {
                        System.err.println("Warning: Could not parse distance in line: " + line);
                    }

                }
            }
        }
    }

    public void loadAttractionData(String filePath) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header if exists
            reader.readLine(); // 跳过标题行 "Place of Interest,Location"
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // 假设是逗号分隔
                if (parts.length >= 2) { // 至少需要景点名和城市名
                    // 假设第一列是景点，第二列是城市+州
                    String attractionName = parts[0].trim();
                    String location = parts[1].trim();
                    if (findCityData(location)!=null){
                        findCityData(location).addAttractionDataSet(attractionName, findCityData(location));
                    }
                }
            }
        }
    }

    public Set<CityData> getCityDataSet(){
        return CityDataSet;
    }

    private CityData findCityData(String cityName){
        if (CityDataSet.isEmpty()) return null;
        for (CityData city: CityDataSet){
            if (city.getCityName().equals(cityName)) return city;
        }
        return null;
    }
}
