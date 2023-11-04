$(document).ready(function ()
{
    var operatingSystemDetails = JSON.parse(homeDashboardService.getOperatingSystemDetails());
    $("#operating-system-name").html(operatingSystemDetails.name);
    $("#username").html(operatingSystemDetails.username);
    $("#number-of-user-apps-running").html(operatingSystemDetails.numberOfUserAppsRunning);
    $("#number-of-processes-running").html(operatingSystemDetails.numberOfProcessesRunning);
    $("#number-of-threads-running").html(operatingSystemDetails.numberOfThreadsRunning);
    $("#operating-system-uptime").html(operatingSystemDetails.uptime);
    $("#hostname").html(operatingSystemDetails.hostname);
    var mainHardwareDetails = JSON.parse(homeDashboardService.getMainHardwareDetails());
    $("#motherboard-name").html(mainHardwareDetails.motherboardName);
    $("#total-RAM").html(mainHardwareDetails.totalRAM);
    $("#free-RAM").html(mainHardwareDetails.freeRAM);
    $("#number-of-graphics-cards").html(mainHardwareDetails.numberOfGraphicsCards);
});