package designpatterns.behavioral;

interface Logger{
    void log(int level, String msg);
}

abstract class LogHandler implements Logger{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    Logger nextLogger;
    LogHandler(Logger nextLogger){
        this.nextLogger=nextLogger;
    }

    public void log(int level,String msg){
        if(nextLogger != null)
            nextLogger.log(level,msg);
        else
            System.out.println("no log to show");
    }
}

class DebugLogHandler extends LogHandler{

    DebugLogHandler(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int level,String msg) {
        if(level == LogHandler.DEBUG)
            System.out.println(" Debug : " + msg);
        else
            super.log(level, msg);

    }
}

class InfoLogHandler extends LogHandler{

    InfoLogHandler(Logger nextLogger) {
        super(nextLogger);
    }
    @Override
    public void log(int level,String msg) {
        if(level == LogHandler.INFO)
            System.out.println(" Info : " + msg);
        else
            super.log(level, msg);

    }
}

class ErrorLogHandler extends LogHandler{

    ErrorLogHandler(Logger nextLogger) {
        super(nextLogger);
    }
    @Override
    public void log(int level,String msg) {
        if(level == LogHandler.ERROR)
            System.out.println(" Error : " + msg);
        else
            super.log(level, msg);

    }
}
public class ChainOfRespPattern {
    public static void main(String[] args) {
        LogHandler logHandler = new InfoLogHandler(new DebugLogHandler(new ErrorLogHandler(null)));

        logHandler.log(LogHandler.INFO,"Basic Messages");
        logHandler.log(LogHandler.DEBUG,"Debug Messages");
        logHandler.log(LogHandler.ERROR,"Error Messages");
        logHandler.log(0,"Error Messages");
    }
}
