package io.github.orionlibs.oriongate_dashboard.tools.home_dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MainHardwareDetails
{
    private String motherboardName;
    private String cpuName;
    private int numberOfCPUCores;
    private int numberOfGraphicsCards;
}
