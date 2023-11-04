package io.github.orionlibs.oriongate_dashboard.tools.home_dashboard;

import io.github.orionlibs.oriongate_dashboard.utils.Utils;
import oshi.SystemInfo;

public class HomeDashboardService
{
    private SystemInfo sysInfo;


    public HomeDashboardService()
    {
        this.sysInfo = new SystemInfo();
    }


    public String getOperatingSystemDetails()
    {
        /*System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().size());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getName());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getLabel());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getTotalSpace());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getName());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getLabel());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getTotalSpace());
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(0).toString());
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(1).toString());
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(2).toString());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(0).getUserName());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(1).getUserName());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(2).getUserName());

        System.out.println(sysInfo.getHardware().getNetworkIFs().get(0).getName());
        System.out.println(sysInfo.getHardware().getPowerSources().get(0).getName());
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorIdentifier().toString());
        System.out.println(sysInfo.getHardware().getProcessor().getMaxFreq());
        System.out.println(sysInfo.getHardware().getProcessor().getLogicalProcessorCount());
        System.out.println(sysInfo.getHardware().getProcessor().getSystemCpuLoad(200L));
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(0L).length);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[0]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[1]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[2]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[3]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[4]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[5]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[6]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[7]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[8]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[9]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[10]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[11]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[12]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[13]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[14]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[15]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[16]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[17]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[18]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[19]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[20]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[21]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[22]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[23]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[24]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[25]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[26]);
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[27]);
        System.out.println(sysInfo.getHardware().getSoundCards().size());
        System.out.println(sysInfo.getHardware().getUsbDevices(true).size());*/
        return Utils.convertObjectToJSON(OperatingSystemDetails.builder()
                        .name(sysInfo.getOperatingSystem().getManufacturer() + " " + sysInfo.getOperatingSystem().getFamily() + " " + sysInfo.getOperatingSystem().getVersionInfo() + " " + System.getProperty("os.arch"))
                        .username(System.getProperty("user.name"))
                        .numberOfUserAppsRunning(sysInfo.getOperatingSystem().getDesktopWindows(false).size())
                        .numberOfProcessesRunning(sysInfo.getOperatingSystem().getProcessCount())
                        .numberOfThreadsRunning(sysInfo.getOperatingSystem().getThreadCount())
                        .uptime(Utils.getDurationInSecondsAsFormattedDaysAndHoursAndMinutes(sysInfo.getOperatingSystem().getSystemUptime()))
                        .hostname(sysInfo.getOperatingSystem().getNetworkParams().getHostName())
                        .build());
    }


    public String getMainHardwareDetails()
    {
        //System.out.println(sysInfo.getHardware().getGraphicsCards().get(0).getName());
        return Utils.convertObjectToJSON(MainHardwareDetails.builder()
                        .motherboardName(sysInfo.getHardware().getComputerSystem().getBaseboard().getManufacturer())
                        .totalRAM("" + (sysInfo.getHardware().getMemory().getTotal() / (1024 * 1024 * 1024)) + "GB")
                        .freeRAM("" + (sysInfo.getHardware().getMemory().getAvailable() / (1024 * 1024 * 1024)) + "GB")
                        .numberOfGraphicsCards(sysInfo.getHardware().getGraphicsCards().size())
                        .build());
    }
}
