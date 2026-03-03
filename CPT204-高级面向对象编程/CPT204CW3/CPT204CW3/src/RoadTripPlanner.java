import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RoadTripPlanner {
    private static final String ATTRACTIONS_FILE = "attractions.csv"; // 移除 data/ 前缀
    private static final String ROADS_FILE = "roads.csv"; // 移除 data/ 前缀

    // 图的邻接列表表示: Map<城市, Map<邻居城市, 距离>>
    private Map<String, Map<String, Integer>> graph;
    // 景点名称到城市的映射: Map<景点名称, 城市名称>
    private Map<String, String> attractionLocations;

    public RoadTripPlanner() {
        // 构造函数中加载数据
        try {
            this.attractionLocations = loadAttractions(ATTRACTIONS_FILE);
            this.graph = loadRoads(ROADS_FILE);
        } catch (IOException e) {
            System.err.println("Error loading data files: " + e.getMessage());
            // 初始化为空，防止 NullPointerException
            this.attractionLocations = new HashMap<>();
            this.graph = new HashMap<>();
        }
    }

    /**
     * 规划路线的核心方法。
     *
     * @param startingCity 起始城市名称
     * @param endingCity   目的地城市名称
     * @param attractions  用户感兴趣的景点名称列表
     * @return 按顺序访问的城市/景点列表，该列表代表总里程最短的路线
     */
    public List<String> route(String startingCity, String endingCity, List<String> attractions) {
        if (graph == null || graph.isEmpty() || attractionLocations == null) {
            System.err.println("Graph or attraction data not loaded properly.");
            return Collections.emptyList();
        }
        if (!graph.containsKey(startingCity) || !graph.containsKey(endingCity)) {
             System.err.println("Starting or ending city not found in the road network.");
             return Collections.emptyList();
        }

        // 1. 确定所有需要访问的关键城市
        Set<String> attractionCitiesSet = new HashSet<>();
        for (String attraction : attractions) {
            String city = attractionLocations.get(attraction);
            if (city != null && graph.containsKey(city)) {
                attractionCitiesSet.add(city);
            } else {
                System.err.println("Warning: AttractionData '" + attraction + "' not found or its city is not in the road network.");
            }
        }
        List<String> attractionCities = new ArrayList<>(attractionCitiesSet);

        // 2. 计算关键城市之间的最短路径距离 (需要实现 A* 或类似算法)
        //    这里需要一个缓存来存储已计算的距离，避免重复计算
        Map<String, Map<String, Integer>> shortestDistances = computeAllPairsShortestPaths(startingCity, endingCity, attractionCities);

        // 3. 找到访问所有景点城市的最优排列 (TSP 变种)
        List<String> bestPath = null;
        int minDistance = Integer.MAX_VALUE;

        // 处理没有景点的情况
        if (attractionCities.isEmpty()) {
             int distance = getShortestDistance(startingCity, endingCity, shortestDistances);
             if (distance != Integer.MAX_VALUE) {
                 // 注意：这里只返回关键点，实际路径需要从 A* 算法中重建
                 return Arrays.asList(startingCity, endingCity);
             } else {
                 return Collections.emptyList(); // 没有路径
             }
        }


        // 生成景点城市的排列
        List<List<String>> permutations = generatePermutations(attractionCities);

        for (List<String> perm : permutations) {
            int currentDistance = 0;
            String lastCity = startingCity;
            boolean possible = true;

            // 计算 Start -> Perm[0]
            int dist = getShortestDistance(lastCity, perm.get(0), shortestDistances);
            if (dist == Integer.MAX_VALUE) {
                possible = false;
            } else {
                currentDistance += dist;
                lastCity = perm.get(0);
            }

            // 计算 Perm[i] -> Perm[i+1]
            for (int i = 0; possible && i < perm.size() - 1; i++) {
                dist = getShortestDistance(lastCity, perm.get(i + 1), shortestDistances);
                if (dist == Integer.MAX_VALUE) {
                    possible = false;
                } else {
                    currentDistance += dist;
                    lastCity = perm.get(i + 1);
                }
            }

            // 计算 Perm[n-1] -> End
            if (possible) {
                dist = getShortestDistance(lastCity, endingCity, shortestDistances);
                if (dist == Integer.MAX_VALUE) {
                    possible = false;
                } else {
                    currentDistance += dist;
                }
            }

            // 更新最短路径
            if (possible && currentDistance < minDistance) {
                minDistance = currentDistance;
                bestPath = new ArrayList<>();
                bestPath.add(startingCity);
                bestPath.addAll(perm);
                bestPath.add(endingCity);
            }
        }

        // 4. 返回结果
        return bestPath != null ? bestPath : Collections.emptyList(); // 如果找不到可行路径则返回空列表
    }

    // --- Helper Methods (需要具体实现) ---

    /**
     * 从 CSV 文件加载景点数据。
     *
     * @param filePath 文件路径
     * @return Map<景点名称, 城市名称>
     * @throws IOException 文件读取异常
     */
    private Map<String, String> loadAttractions(String filePath) throws IOException {
        Map<String, String> locations = new HashMap<>();
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
                    locations.put(attractionName, location);
                }
            }
        }
        return locations;
    }

    /**
     * 从 CSV 文件加载道路数据并构建图。
     *
     * @param filePath 文件路径
     * @return Map<城市, Map<邻居城市, 距离>>
     * @throws IOException 文件读取异常
     */
    private Map<String, Map<String, Integer>> loadRoads(String filePath) throws IOException {
        Map<String, Map<String, Integer>> adj = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header if exists
            reader.readLine(); // 跳过标题行 "CityA,CityB,Distance"
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // 假设是逗号分隔
                if (parts.length >= 3) {
                    String city1 = parts[0].trim();
                    String city2 = parts[1].trim();
                    try {
                        Integer distance = (Integer) Integer.parseInt(parts[2].trim());

                        // 无向图，双向添加边
                        adj.computeIfAbsent(city1, k -> new HashMap<>()).put(city2, distance);
                        adj.computeIfAbsent(city2, k -> new HashMap<>()).put(city1, distance);
                    } catch (NumberFormatException e) {
                         System.err.println("Warning: Could not parse distance in line: " + line);
                    }
                }
            }
        }
        return adj;
    }

    /**
     * 计算所有关键城市对之间的最短路径距离。
     *
     * @param startCity 起始城市
     * @param endCity 终点城市
     * @param attractionCities 景点城市列表
     * @return 嵌套 Map，存储任意两个关键城市间的最短距离
     */
    private Map<String, Map<String, Integer>> computeAllPairsShortestPaths(String startCity, String endCity, List<String> attractionCities) {
        Map<String, Map<String, Integer>> allDistances = new HashMap<>();
        List<String> keyCities = new ArrayList<>(attractionCities);
        keyCities.add(startCity);
        keyCities.add(endCity); // 使用 Set 避免重复添加 start/end 如果它们也是景点城市

        Set<String> uniqueKeyCities = new HashSet<>(keyCities);

        for (String city1 : uniqueKeyCities) {
            allDistances.put(city1, new HashMap<>());
            for (String city2 : uniqueKeyCities) {
                if (!city1.equals(city2)) {
                    // 调用 A* 算法计算 city1 和 city2 之间的最短距离
                    int distance = aStar(city1, city2);
                    allDistances.get(city1).put(city2, Integer.valueOf(distance));
                } else {
                     allDistances.get(city1).put(city2, Integer.valueOf(0));
                }
            }
        }
        return allDistances; // 返回包含所有关键点对距离的 Map
    }

    /**
     * 使用 A* 算法计算两个城市间的最短距离。
     *
     * @param start 起始城市
     * @param end   目标城市
     * @return 最短距离，如果不可达则返回 Integer.MAX_VALUE
     */
    private int aStar(String start, String end) {
         if (!graph.containsKey(start) || !graph.containsKey(end)) {
             return Integer.MAX_VALUE;
         }
         if (start.equals(end)) return 0;

         // 启发式函数：简单估计两个城市之间的距离
         // 注意：因为没有地理坐标，我们使用一个简单的启发式函数
         // 实际应用中，应该使用地理距离或其他合适的启发函数
         Map<String, Integer> heuristic = new HashMap<>();
         for (String city : graph.keySet()) {
             // 这里我们使用一个非常简单的启发式估计，仅作示范
             // 在实际应用中，这应该基于实际地理距离
             heuristic.put(city, Integer.valueOf(0)); // 如果没有好的启发式，可以退化为 Dijkstra
         }

         // f(n) = g(n) + h(n)，其中 g(n) 是起点到 n 的实际距离，h(n) 是 n 到终点的启发式距离
         Map<String, Integer> gScores = new HashMap<>(); // 存储 g(n)
         Map<String, Integer> fScores = new HashMap<>(); // 存储 f(n)
         
         // 使用 f 值作为优先级
         PriorityQueue<Map.Entry<String, Integer>> openSet = new PriorityQueue<>(Map.Entry.comparingByValue());
         Set<String> closedSet = new HashSet<>(); // 已访问的节点

         // 初始化所有城市的 g 值为无穷大
         for (String city : graph.keySet()) {
             gScores.put(city, Integer.valueOf(Integer.MAX_VALUE));
             fScores.put(city, Integer.valueOf(Integer.MAX_VALUE));
         }
         gScores.put(start, Integer.valueOf(0));
         fScores.put(start, heuristic.get(start)); // f(start) = g(start) + h(start) = 0 + h(start)
         openSet.add(new AbstractMap.SimpleEntry<>(start, fScores.get(start)));

         while (!openSet.isEmpty()) {
             Map.Entry<String, Integer> currentEntry = openSet.poll();
             String currentCity = currentEntry.getKey();
             
             if (currentCity.equals(end)) {
                 return gScores.get(currentCity); // 找到最短路径
             }
             
             if (closedSet.contains(currentCity)) {
                 continue; // 已处理过此节点
             }
             closedSet.add(currentCity);

             // 访问邻居
             Map<String, Integer> neighbors = graph.getOrDefault(currentCity, Collections.emptyMap());
             for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                 String neighbor = neighborEntry.getKey();
                 int weight = neighborEntry.getValue();
                 
                 if (closedSet.contains(neighbor)) {
                     continue; // 跳过已处理的节点
                 }
                 
                 // 计算新的 g 值
                 int tentativeGScore = gScores.get(currentCity) + weight;
                 
                 if (tentativeGScore < gScores.get(neighbor)) {
                     // 找到更好的路径
                     gScores.put(neighbor, Integer.valueOf(tentativeGScore));
                     fScores.put(neighbor, Integer.valueOf(tentativeGScore + heuristic.get(neighbor)));
                     openSet.add(new AbstractMap.SimpleEntry<>(neighbor, fScores.get(neighbor)));
                 }
             }
         }

         return Integer.MAX_VALUE; // 如果 end 不可达
    }

    /**
     * 从预先计算好的距离图中获取两个城市间的距离。
     *
     * @param city1           第一个城市
     * @param city2           第二个城市
     * @param shortestDistances 预计算的距离 Map
     * @return 距离，如果不存在则返回 Integer.MAX_VALUE
     */
    private int getShortestDistance(String city1, String city2, Map<String, Map<String, Integer>> shortestDistances) {
        return shortestDistances.getOrDefault(city1, Collections.emptyMap()).getOrDefault(city2, Integer.valueOf(Integer.MAX_VALUE));
    }

    /**
     * 生成列表元素的所有排列。
     *
     * @param items 要排列的列表
     * @return 包含所有排列的列表
     */
    private List<List<String>> generatePermutations(List<String> items) {
        List<List<String>> result = new ArrayList<>();
        if (items == null || items.isEmpty()) {
            result.add(new ArrayList<>()); // 对于空列表，返回包含一个空列表的结果
            return result;
        }
        generatePermutationsHelper(items, 0, result);
        return result; // 返回包含所有排列的列表
    }

     private void generatePermutationsHelper(List<String> items, int start, List<List<String>> result) {
        if (start >= items.size()) {
            result.add(new ArrayList<>(items)); // 将当前排列的副本添加到结果中
            return;
        }
        for (int i = start; i < items.size(); i++) {
            // 交换元素
            Collections.swap(items, start, i);
            // 递归生成剩余部分的排列
            generatePermutationsHelper(items, start + 1, result);
            // 回溯：恢复原始顺序
            Collections.swap(items, start, i);
        }
    }


    // --- RoadTripOptimizer Method for Testing ---
    public static void main(String[] args) {
        RoadTripPlanner planner = new RoadTripPlanner();
        Scanner scanner = new Scanner(System.in);

        // 检查数据是否加载成功
        if (planner.graph == null || planner.graph.isEmpty() || planner.attractionLocations == null || planner.attractionLocations.isEmpty()) {
            System.err.println("Failed to load necessary data. Exiting.");
            scanner.close(); // 关闭 scanner
            return;
        }


        // 1. 显示可用城市
        System.out.println("Available cities:");
        List<String> cities = new ArrayList<>(planner.graph.keySet());
        Collections.sort(cities); // 排序以便查看
        for (int i = 0; i < cities.size(); i++) {
            System.out.printf("%-20s", cities.get(i));
            if ((i + 1) % 5 == 0) { // 每行显示5个城市
                System.out.println();
            }
        }
        System.out.println("\n--------------------");

        // 2. 获取起始城市
        String start = "";
        while (start.isEmpty() || !planner.graph.containsKey(start)) {
            System.out.print("Enter starting city: ");
            start = scanner.nextLine().trim();
            if (!planner.graph.containsKey(start)) {
                System.out.println("Invalid city name. Please choose from the list above.");
            }
        }

        // 3. 获取目的地城市
        String end = "";
        while (end.isEmpty() || !planner.graph.containsKey(end)) {
            System.out.print("Enter ending city: ");
            end = scanner.nextLine().trim();
             if (end.equals(start)) {
                 System.out.println("Ending city cannot be the same as the starting city.");
                 end = ""; // 重置以便重新输入
             } else if (!planner.graph.containsKey(end)) {
                System.out.println("Invalid city name. Please choose from the list above.");
            }
        }

        // 4. 显示可用景点
        System.out.println("\nAvailable attractions:");
        List<String> allAttractions = new ArrayList<>(planner.attractionLocations.keySet());
        Collections.sort(allAttractions); // 排序
        for (int i = 0; i < allAttractions.size(); i++) {
            System.out.printf("%-30s", allAttractions.get(i));
             if ((i + 1) % 3 == 0) { // 每行显示3个景点
                 System.out.println();
             }
        }
         System.out.println("\n--------------------");


        // 5. 获取要访问的景点
        List<String> attractionsToVisit = new ArrayList<>();
        System.out.print("Enter attractions to visit (comma-separated, or leave blank for none): ");
        String attractionsInput = scanner.nextLine().trim();
        if (!attractionsInput.isEmpty()) {
            String[] attractionNames = attractionsInput.split(",");
            for (String name : attractionNames) {
                String trimmedName = name.trim();
                if (planner.attractionLocations.containsKey(trimmedName)) {
                    attractionsToVisit.add(trimmedName);
                } else {
                    System.out.println("Warning: AttractionData '" + trimmedName + "' not found and will be ignored.");
                }
            }
        }

        scanner.close(); // 关闭 scanner

        // --- 执行路线规划 ---
        System.out.println("\nPlanning trip from " + start + " to " + end);
        if (!attractionsToVisit.isEmpty()) {
             System.out.println("Visiting attractions: " + attractionsToVisit);
        } else {
             System.out.println("No attractions selected.");
        }


        List<String> route = planner.route(start, end, attractionsToVisit);

        if (route.isEmpty()) {
            System.out.println("Could not find a valid route.");
        } else {
            System.out.println("Optimal route sequence:");
            System.out.println(String.join(" -> ", route));

            // 可选：计算并打印总距离
            int totalDistance = 0;
            // 注意：这里需要重新计算包含用户选择的景点的距离，或者在 route 方法内部返回距离
            // 为了简单起见，我们重新计算一次
             Map<String, Map<String, Integer>> distances = planner.computeAllPairsShortestPaths(start, end, planner.getAttractionCities(attractionsToVisit));
            boolean possibleRoute = true;
            for (int i = 0; i < route.size() - 1; i++) {
                int dist = planner.getShortestDistance(route.get(i), route.get(i+1), distances);
                 if (dist == Integer.MAX_VALUE) {
                     System.err.println("Error: Could not calculate distance between " + route.get(i) + " and " + route.get(i+1) + " for the final route.");
                     totalDistance = -1; // Indicate error
                     possibleRoute = false;
                     break;
                 }
                totalDistance += dist;
            }
             if (possibleRoute && totalDistance != -1) {
                 System.out.println("Estimated total distance: " + totalDistance + " miles (based on shortest paths between key points)");
             } else if (!possibleRoute) {
                  System.out.println("Could not calculate the total distance for the found sequence.");
             }
        }

        // 移除或注释掉之前的硬编码测试用例
        /*
         System.out.println("\n--- Test Case 2: No Attractions ---");
         // ... (之前的测试代码) ...
         System.out.println("\n--- Test Case 3: Non-existent AttractionData ---");
         // ... (之前的测试代码) ...
        */
    }

     // Helper to get attraction cities for distance calculation in main
     private List<String> getAttractionCities(List<String> attractions) {
         Set<String> cities = new HashSet<>();
         for (String attraction : attractions) {
             String city = this.attractionLocations.get(attraction);
             if (city != null && this.graph.containsKey(city)) {
                 cities.add(city);
             }
         }
         return new ArrayList<>(cities);
     }
}
