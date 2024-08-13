package templateMethod;
// Класс реализует прочтение лога алгоритма

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoemReader extends LogReader {

    private String data;

    @Override
    public Object getDataSource() {
        // TODO Auto-generated method stub
        return data;
    }

    @Override
    public void setDataSource(Object data) {
        // TODO Auto-generated method stub
        this.data = data.toString();
    }

    public PoemReader() {

    }

     public PoemReader(String data) {
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(data);
        List<String> logList = new ArrayList<>();
        int counter = 0;
        while (scanner.hasNextLine()) {
            counter++;
            if(counter >= position) {
                position = counter;
                String line = scanner.nextLine();
                logList.add(line);
            }
            else {
                scanner.nextLine();
            }
        }
        scanner.close();
        return logList;
    }

    @Override
    protected LogEntry parserLogEntry(String stringEntry) {
        // TODO Auto-generated method stub
        return new LogEntry(stringEntry);
    }
    
}
