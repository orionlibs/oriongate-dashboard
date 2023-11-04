$(document).ready(function ()
{
    buildOperatingSystemDetailsTable();
    buildHardwareDetailsTable();
    buildRAMChart();
});


function buildOperatingSystemDetailsTable()
{
    var operatingSystemDetails = JSON.parse(homeDashboardService.getOperatingSystemDetails());
    $("#operating-system-name").html(operatingSystemDetails.name);
    $("#username").html(operatingSystemDetails.username);
    $("#number-of-user-apps-running").html(operatingSystemDetails.numberOfUserAppsRunning);
    $("#number-of-processes-running").html(operatingSystemDetails.numberOfProcessesRunning);
    $("#number-of-threads-running").html(operatingSystemDetails.numberOfThreadsRunning);
    $("#operating-system-uptime").html(operatingSystemDetails.uptime);
    $("#hostname").html(operatingSystemDetails.hostname);
}


function buildHardwareDetailsTable()
{
    var mainHardwareDetails = JSON.parse(homeDashboardService.getMainHardwareDetails());
    $("#motherboard-name").html(mainHardwareDetails.motherboardName);
    $("#cpu-name").html(mainHardwareDetails.cpuName);
    $("#cpu-cores").html(mainHardwareDetails.numberOfCPUCores);
    $("#number-of-graphics-cards").html(mainHardwareDetails.numberOfGraphicsCards);
}


function buildRAMChart()
{
    var ramChartValues = common.convertJavaListToArray(homeDashboardService.getRAMValuesForChart());
    var ramChartLabels = common.convertJavaListToArray(homeDashboardService.getRAMLabelsForChart());
    oriongateCharts.buildDonutChartWith2Elements("#ram-chart", ramChartValues, ramChartLabels);
}