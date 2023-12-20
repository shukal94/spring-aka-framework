package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.web.config.properties.impl.ChromeCapabilities;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ChromeCapabilities.class})
public class WebConfig {

}
