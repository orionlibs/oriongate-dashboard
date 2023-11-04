$(document).ready(function ()
{
    var operatingSystemDetails = JSON.parse(homeDashboardService.getOperatingSystemDetails());
    $("#operating-system-name").html(operatingSystemDetails.operatingSystemName);
    $("#number-of-user-apps-running").html(operatingSystemDetails.numberOfUserAppsRunning);
});