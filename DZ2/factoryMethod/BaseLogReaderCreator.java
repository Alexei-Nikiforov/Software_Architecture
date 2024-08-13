package factoryMethod;

import templateMethod.LogReader;

public abstract class BaseLogReaderCreator {

    protected LogReader createLogReader(LogType logType, Object data) {
        LogReader logReader = createLogReaderInstance (logType);
        
        // Выполнение подготовительных действий

        logReader.setDataSource(data);
        logReader.setCurrentPosition(1);

        return logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);
    
}
