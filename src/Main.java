import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Give file path and create an instance of CSVReader to read the file*/
        CsvReader newCsv = new CsvReader();

        /*Call readData() method and take the returned list into a List of Data Class type*/
        List<Data> resultList = newCsv.readData();
        List<Data> dateFilteredList; //Create another List of Data Class type to keep date filtered data in


        /*Create and instance of date object to filter 10/08/2016*/
        MyDate date = new MyDate(2016, Calendar.AUGUST,10);

        /*Take the date filtered data into the list by using Java-8 Stream API methods*/
        dateFilteredList = resultList.stream().filter(data ->
                date.equals(data.getTime())).sorted(Comparator.comparing(Data::getClientId)).collect(Collectors.toList());

        /*Create an instance of DataSorting class to obtain the sorted and counted (desired) output*/
        DataSorting dataSorting = new DataSorting(dateFilteredList);
        Map<Integer, Integer> sortedOutput = dataSorting.sortData();

        CsvWriter csvWrite = new CsvWriter(sortedOutput);
        csvWrite.writeData();

    }

}