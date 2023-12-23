package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.web.config.properties.impl.ChromeProperties;
import ch.shukalovi.selenium.base.framework.web.config.properties.impl.EdgeProperties;
import ch.shukalovi.selenium.base.framework.web.config.properties.impl.FirefoxProperties;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;


// TODO: get rid of imports
@Configuration
@EnableConfigurationProperties({ChromeProperties.class, FirefoxProperties.class, EdgeProperties.class})
public class WebConfig {
    @Bean
    @Qualifier(value = "chrome")
    public MutableCapabilities chromeOptions(ChromeProperties props) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(props.getArgs());
        Map<String, Object> experimentalOptions = props.getPrefs();
        experimentalOptions.keySet().forEach(k -> options.setExperimentalOption(k, experimentalOptions.get(k)));
        options.setBrowserVersion(props.getVersion());
        options.setAcceptInsecureCerts(props.getAcceptInsecureCerts());
        options.setPlatformName(props.getPlatformName());

        return options;
    }

    @Bean
    @Qualifier(value = "firefox")
    public MutableCapabilities firefoxOptions(FirefoxProperties props) {
        FirefoxProfile browserProfile = new FirefoxProfile();
        browserProfile.setAcceptUntrustedCertificates(props.getAcceptInsecureCerts());
        Map<String, Object> prefs = props.getPrefs();
        prefs.keySet().forEach(k -> browserProfile.setPreference(k, prefs.get(k)));

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(browserProfile);
        options.setBrowserVersion(props.getVersion());
        options.setPlatformName(props.getPlatformName());

        return options;
    }

    @Bean
    @Qualifier(value = "edge")
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
