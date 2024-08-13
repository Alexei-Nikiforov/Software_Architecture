package factoryMethod;

import templateMethod.LogEntry;
import templateMethod.LogReader;

public class Programm {

     public static String data = """
            У локуморья дуб зеленый;
            Златая цепь на дубе том:
            И днем и ночью кот ученый
            Все ходит по цепи кругом;
            Идет направо - песнь заводит,
            Налево - сказку говорит.""";
    public static void main(String[] args) {

        LogReader logReader = new ConcreteReaderCreator()
            .createLogReader(LogType.Text, data);

        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }
        
    }
}
