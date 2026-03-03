import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class RoadTripOptimizer {
    private Double totalDistance;  //最短路径长度
    private static String roadsFilePath = "CW3_Data_Files/roads.csv";
    private static String attractionsFilePath = "CW3_Data_Files/attractions.csv";



    /**
     * 规划路线的核心方法。
     *
     * @param startingCity 起始城市名称
     * @param endingCity   目的地城市名称
     * @param attractions  用户感兴趣的景点名称列表
     * @return 按顺序访问的城市/景点列表，该列表代表总里程最短的路线
     */
    public List<String> route(CityData startingCity, CityData endingCity, List<AttractionData> attractions) {
        totalDistance = -1.0;
        return null;
    }

    public static void main(String[] args) throws IOException {
        DataLoader myDataloader = new DataLoader(roadsFilePath);
        myDataloader.loadAttractionData(attractionsFilePath);
        Set<CityData> cityDataSet = myDataloader.getCityDataSet();

        // 1. 显示可用城市
        System.out.println("Available cities:");
        for (CityData city: cityDataSet){
            System.out.print(city.getCityName()+", ");
        }

    }
}