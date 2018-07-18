import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

    private String FilePath;

    //constructor for File location
    public CsvReader(String FilePath){
        this.FilePath = FilePath;
    }

    public List<Data> readData() throws IOException {

        String csvFile = FilePath;
        List<Data> rowList = new LinkedList<>();
        String  line = "";
        String cvsSplitBy = "\t";
        String encoding = "UTF-8";
        BufferedReader br = null;

        try {
            int counterRow = 0;
            br =  new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), encoding));
            String title = br.readLine(); //take title line of the CSV into ..
            while ((line = br.readLine()) != null) {
                //line=line.replaceAll(",,", ",NA,");
                Object[] obj = (line.split(cvsSplitBy));

                /*create new instance of Data Class and set parameters*/
                Data data = new Data();
                data.setPlayId(String.valueOf(obj[0]));
                data.setSongId(Integer.valueOf(String.valueOf(obj[1])));
                data.setClientId(Integer.valueOf(String.valueOf(obj[2])));
                String sDate1=String.valueOf(obj[3]);
                sDate1 = sDate1.substring(0,sDate1.length());

                try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                    data.setTime(date1);
                }catch (Exception e){
                    e.printStackTrace();
                }

                /*add the date from Data object to the rowList*/
                rowList.add(data);
                counterRow++; //count how many rows of the csv scanned
            }
            //System.out.println("counterRow is: "+counterRow);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowList;
    }


}