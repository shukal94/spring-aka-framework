package ch.shukalovi.selenium.base.framework.web.config.properties.impl;

import ch.shukalovi.selenium.base.framework.web.config.properties.BaseCapabilities;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "chrome")
public class ChromeCapabilities extends BaseCapabilities {
    private String[] args;
    private Map<String, Object> prefs;

    public void setArgs(String args) {
        String[] argsTemp = args.split(",");
        this.args = Arrays.stream(argsTemp).map(String::trim).toList().toArray(new String[] {});
    }
}
