package io.github.orionlibs.oriongate_dashboard;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FrontEndLogger
{
    private static String logFilePath = MainClass.applicationPath + "/logs.log";
    private Logger log;


    public FrontEndLogger()
    {
        log = Logger.getLogger(FrontEndLogger.class.getName());
        try
        {
            FileHandler fileHandlerForInfoLog = new FileHandler(logFilePath);
            fileHandlerForInfoLog.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandlerForInfoLog);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public void info(String message)
    {
        log.info(message);
    }


    public void warning(String message)
    {
        log.warning(message);
    }


    public void error(String message)
    {
        log.severe(message);
    }
}
