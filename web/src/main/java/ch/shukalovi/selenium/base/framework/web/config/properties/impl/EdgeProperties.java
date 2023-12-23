package ch.shukalovi.selenium.base.framework.web.config.properties.impl;

import ch.shukalovi.selenium.base.framework.web.config.properties.PropertiesBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.PageLoadStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "edge")
public class EdgeProperties extends PropertiesBase {
    private PageLoadStrategy pageLoadStrategy;
    private Map<String, Object> capabilities;

    public void setPageLoadStrategy(String pageLoadStrategy) {
        this.pageLoadStrategy = PageLoadStrategy.fromString(pageLoadStrategy);
    }
}
