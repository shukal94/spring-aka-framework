package ch.shukalovi.selenium.base.framework.web.config.properties;

import lombok.Data;

@Data
public abstract class BaseCapabilities implements Capabilities {
    private String version;
    private String threadsNumber;
}
