package io.github.orionlibs.oriongate_dashboard.tools.home_dashboard;

import java.util.Arrays;
import oshi.SystemInfo;

public class HomeDashboardService
{
    public String getOperatingSystemDetails()
    {
        SystemInfo sysInfo = new SystemInfo();
        /*System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().size());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getName());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getLabel());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(0).getTotalSpace());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getName());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getLabel());
        System.out.println(sysInfo.getOperatingSystem().getFileSystem().getFileStores().get(1).getTotalSpace());
        System.out.println(sysInfo.getOperatingSystem().getServices().size());
        System.out.println(sysInfo.getOperatingSystem().getSystemUptime() + " seconds");
        System.out.println(sysInfo.getOperatingSystem().getDesktopWindows(false).size() + " user apps running");
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(0).toString());
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(1).toString());
        System.out.println(sysInfo.getOperatingSystem().getInternetProtocolStats().getConnections().get(2).toString());
        System.out.println(sysInfo.getOperatingSystem().getNetworkParams().getHostName());
        System.out.println(sysInfo.getOperatingSystem().getProcessCount());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(0).getUserName());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(1).getUserName());
        System.out.println(sysInfo.getOperatingSystem().getSessions().get(2).getUserName());
        System.out.println(sysInfo.getOperatingSystem().getSystemBootTime());
        System.out.println(sysInfo.getOperatingSystem().getThreadCount());
        System.out.println(sysInfo.getHardware().getComputerSystem().getManufacturer());
        System.out.println(sysInfo.getHardware().getComputerSystem().getHardwareUUID());
        System.out.println(sysInfo.getHardware().getComputerSystem().getBaseboard().getManufacturer());
        System.out.println(sysInfo.getHardware().getComputerSystem().getBaseboard().getModel());
        System.out.println(sysInfo.getHardware().getComputerSystem().getModel());
        System.out.println(sysInfo.getHardware().getComputerSystem().getFirmware().getName());
        System.out.println(sysInfo.getHardware().getMemory().getTotal());
        System.out.println(sysInfo.getHardware().getGraphicsCards().get(0).getName());
        System.out.println(sysInfo.getHardware().getNetworkIFs().get(0).getName());
        System.out.println(sysInfo.getHardware().getPowerSources().get(0).getName());*/
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorIdentifier().toString());
        System.out.println(sysInfo.getHardware().getProcessor().getMaxFreq());
        System.out.println(sysInfo.getHardware().getProcessor().getLogicalProcessorCount());
        System.out.println(sysInfo.getHardware().getProcessor().getSystemCpuLoad(200L));
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(0L).length);
        /*System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[0]);
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
        System.out.println(sysInfo.getHardware().getProcessor().getProcessorCpuLoad(200L)[27]);*/
        System.out.println(sysInfo.getHardware().getSoundCards().size());
        System.out.println(sysInfo.getHardware().getUsbDevices(true).size());
        return sysInfo.getOperatingSystem().getManufacturer() + " " + sysInfo.getOperatingSystem().getFamily() + " " + sysInfo.getOperatingSystem().getVersionInfo() + " " + sysInfo.getOperatingSystem().getBitness() + "-bit";
    }
}
