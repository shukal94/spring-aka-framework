package ch.shukalovi.selenium.base.framework.web.config.timeouts;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "web.timeout")
public class TimeoutProperties {
    private Long implicitTimeout;
    private Long pageLoadTimeout;
    private Long scriptTimeout;
}
