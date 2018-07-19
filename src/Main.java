import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Give file path and create an instance of CSVReader to read the file*/
        String FilePath = "exhibita.csv";
        CsvReader newCsv = new CsvReader(FilePath);

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


        System.out.println("***********************************************************************");
        /*Print the sortedOutput entry in the for each loop*/
        for(Map.Entry<Integer, Integer> entry:sortedOutput.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        CsvWriter csvWrite = new CsvWriter(sortedOutput);
        csvWrite.writeData();

    }

    /*Extending java Data class to set required date to filter the data*/
    static class MyDate extends Date {

        MyDate(int year, int month, int day){
            super(year-1900,month,day);
        }
        @Override
        public boolean equals(Object obj) {
            Date date = (Date) obj;
            return this.getYear() == date.getYear()
                    && this.getMonth() == date.getMonth()
                    && this.getDay() == date.getDay();
        }
    }

}