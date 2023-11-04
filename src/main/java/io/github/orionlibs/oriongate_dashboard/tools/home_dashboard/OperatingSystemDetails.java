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
public class OperatingSystemDetails
{
    private String operatingSystemName;
    private int numberOfUserAppsRunning;
}
