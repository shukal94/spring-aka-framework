package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.web.config.properties.impl.ChromeProperties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties({ChromeProperties.class})
public class WebConfig {
    @Bean
    public ChromeOptions chromeOptions(ChromeProperties caps) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(caps.getArgs());
        Map<String, Object> experimentalOptions = caps.getPrefs();
        experimentalOptions.keySet().forEach(k -> options.setExperimentalOption(k, experimentalOptions.get(k)));
        options.setBrowserVersion(caps.getVersion());

        return options;
    }

}
