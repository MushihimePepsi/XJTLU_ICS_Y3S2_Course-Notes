/**
 * 用于保存每个景点的信息
 */
public class AttractionData {
    private final String attractionName;
    private final CityData location;
    public AttractionData(String attractionName, CityData location){
        this.attractionName = attractionName;
        this.location =location;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public CityData getLocation() {
        return location;
    }
}
