package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.web.config.properties.impl.ChromeProperties;
import ch.shukalovi.selenium.base.framework.web.config.properties.impl.EdgeProperties;
import ch.shukalovi.selenium.base.framework.web.config.properties.impl.FirefoxProperties;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties({ChromeProperties.class, FirefoxProperties.class, EdgeProperties.class})
public class BrowserConfig {

    @Bean
    @ConditionalOnProperty(name="web.browser", havingValue = "chrome")
    public MutableCapabilities chromeOptions(ChromeProperties props) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(props.getArgs());
        options.setExperimentalOption("prefs", props.getPrefs());
        options.setBrowserVersion(props.getVersion());
        options.setAcceptInsecureCerts(props.getAcceptInsecureCerts());
        options.setPlatformName(props.getPlatformName());

        return options;
    }

    // TODO: debug ff setup
    @Bean
    @ConditionalOnProperty(name="web.browser", havingValue = "firefox")
    public MutableCapabilities firefoxOptions(FirefoxProperties props) {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile browserProfile = new FirefoxProfile();
        browserProfile.setAcceptUntrustedCertificates(props.getAcceptInsecureCerts());
        Map<String, Object> prefs = props.getPrefs();
        prefs.keySet().forEach(k -> browserProfile.setPreference(k, prefs.get(k)));

        options.setProfile(browserProfile);
        options.setBrowserVersion(props.getVersion());
        options.setPlatformName(props.getPlatformName());

        return options;
    }

    // TODO: debug edge setup
    @Bean
    @ConditionalOnProperty(name="web.browser", havingValue = "edge")
    public MutableCapabilities edgeOptions(EdgeProperties props) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(props.getPageLoadStrategy());
        edgeOptions.setPlatformName(props.getPlatformName());
        edgeOptions.setBrowserVersion(props.getVersion());
        edgeOptions.setAcceptInsecureCerts(props.getAcceptInsecureCerts());

        Map<String, Object> capabilities = props.getCapabilities();
        capabilities.keySet().forEach(k -> edgeOptions.setCapability(k, capabilities.get(k)));

        return edgeOptions;
    }

}
