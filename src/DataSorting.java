import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataSorting {

    private List<Data> dataList;

    public DataSorting(List<Data> dataList) {
        this.dataList = dataList;
    }

    public Map<Integer, Integer> sortData(){

        Map<Integer, Integer> sortedOutput = new HashMap<Integer, Integer>();

        /*Create a HashMap to take date filtered list and group By Client and Song Id; stream.Collecter class of Java-8 is used*/
        Map<Integer, Map<Integer, Long>> map = dataList.stream().collect(
                Collectors.groupingBy(Data::getClientId,Collectors.groupingBy(Data::getSongId, Collectors.counting()))
        );

        /*Create another Hashmap to store occurences of song Id and Client Id in the separate Hashmap*/
        Map<Integer, Integer> mapResult = new HashMap<>();
        for (int key : map.keySet()){
            mapResult.put(key, map.get(key).size());
        }

        /*Count the occurences of Client Id that corresponds to the ditinct listened Song ID in this map that gives the desired output*/
        for (Integer c : mapResult.values()) {
            int value = sortedOutput.get(c) == null ? 0 : sortedOutput.get(c);
            sortedOutput.put(c, value + 1);
        }


        return sortedOutput;
    }


}