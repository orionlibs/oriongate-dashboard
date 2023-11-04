$(document).ready(function ()
{
    var operatingSystemDetails = JSON.parse(homeDashboardService.getOperatingSystemDetails());
    $("#operating-system-name").html(operatingSystemDetails.name);
    $("#number-of-user-apps-running").html(operatingSystemDetails.numberOfUserAppsRunning);
    $("#number-of-processes-running").html(operatingSystemDetails.numberOfProcessesRunning);
    $("#number-of-threads-running").html(operatingSystemDetails.numberOfThreadsRunning);
    $("#operating-system-uptime").html(operatingSystemDetails.uptime);
    $("#hostname").html(operatingSystemDetails.hostname);
});