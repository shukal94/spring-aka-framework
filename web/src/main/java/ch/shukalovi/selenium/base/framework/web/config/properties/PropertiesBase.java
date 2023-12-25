package ch.shukalovi.selenium.base.framework.web.config.properties;

import lombok.Data;

// TODO: revisit chrome capabilities
@Data
public abstract class PropertiesBase implements Properties {
    private String version;
    private String platformName;
    private Boolean acceptInsecureCerts;
}
