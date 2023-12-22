package ch.shukalovi.selenium.base.framework.web.config.properties;

import lombok.Data;

//TODO: add platform
@Data
public abstract class PropertiesBase implements Capabilities {
    private String version;
}
