package factoryMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import templateMethod.LogEntry;
import templateMethod.LogReader;

public class DatabaseReader extends LogReader {

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

    public DatabaseReader() {
    }

    public DatabaseReader(String data) {
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        // TODO Auto-generated method stub
        List<String> logList = new ArrayList<>();
        int counter = 0;
        String line;
        try {
            FileReader fileReader = new FileReader("log.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
                if(counter >= position) {
                    position = counter;
                    System.out.println(line);
                    logList.add(line);
                }
                else {
                    System.out.println(line);
                }
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return logList;
    }

    @Override
    protected LogEntry parserLogEntry(String stringEntry) {
        // TODO Auto-generated method stub
        return new LogEntry(stringEntry);
    }
    
}
