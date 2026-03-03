import java.util.*;

/**
 * 储存城市到每个相邻城市的距离，以及城市的景点
 */
public class CityData {
    private final String cityName;
    private HashMap<CityData, Double> adjacentDistanceMap = new HashMap<>();
    private Set<AttractionData> attractionDataSet = new HashSet<>();
    public CityData(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public Map<CityData, Double> getAdjacentDistanceMap() {
        return adjacentDistanceMap;
    }

    public void setAdjacentDistanceMap(HashMap<CityData, Double> adjacentDistanceMap) {
        this.adjacentDistanceMap = adjacentDistanceMap;
    }

    public void addAdjacentDistanceMap(CityData city, Double distance){
        this.adjacentDistanceMap.put(city, distance);
    }

    public Set<AttractionData> getAttractionDataSet() {
        return attractionDataSet;
    }

    public void addAttractionDataSet(String attractionName, CityData location){
        this.attractionDataSet.add(new AttractionData(attractionName, location));
    }

    public void setAttractionDataSet(Set<AttractionData> attractionDataSet) {
        this.attractionDataSet = attractionDataSet;
    }
}
