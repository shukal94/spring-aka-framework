package ch.shukalovi.selenium.base.framework.web.config.properties.impl;

import ch.shukalovi.selenium.base.framework.web.config.properties.PropertiesBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// TODO: add insecure certs
@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "chrome")
public class ChromeProperties extends PropertiesBase {
    private List<String> args;
    private Map<String, Object> prefs;

    public void setArgs(String args) {
        String[] argsTemp = args.split(",");
        this.args = Arrays.stream(argsTemp).map(String::trim).toList();
    }
}
