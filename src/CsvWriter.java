import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriter {

    private static final String OUTPUT_PATH = "C:/outputData.csv";
    private static final String FILE_HEADER = "DISTINCT_PLAY_COUNT,CLIENT_COUNT";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private Map<Integer, Integer> resultData;

    public CsvWriter(Map<Integer, Integer> resultData) {
        this.resultData = resultData;
    }

    public void writeData() {

        FileWriter writer = null;
        try {
            writer = new FileWriter(OUTPUT_PATH);
            writer.append(FILE_HEADER.toString());
            writer.append(NEW_LINE_SEPARATOR);

            for (Map.Entry<Integer, Integer> entry : resultData.entrySet()) {
                writer.write(entry.getKey().toString());
                writer.append(COMMA_DELIMITER);
                writer.write(entry.getValue().toString());
                writer.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("outputData.csv File: Write Success!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();

            }
        }

    }
}