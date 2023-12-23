package ch.shukalovi.selenium.base.framework.web.config.properties.impl;

import ch.shukalovi.selenium.base.framework.web.config.properties.PropertiesBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "firefox")
public class FirefoxProperties extends PropertiesBase {
    private Map<String, Object> prefs;
}
