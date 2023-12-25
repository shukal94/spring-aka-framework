package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.common.config.ThreadScopeConfig;
import ch.shukalovi.selenium.base.framework.web.exception.UnsupportedBrowserException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import static ch.shukalovi.selenium.base.framework.common.util.constant.CommonConstant.THREAD_SCOPE;

// TODO: get rid of imports
@Import({ThreadScopeConfig.class})
@Configuration
public class WebConfig {
    @Value("${browser}")
    private String browser;

    private final MutableCapabilities capabilities;

    public WebConfig(MutableCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Bean
    @Scope(scopeName = THREAD_SCOPE)
    public WebDriver webDriver() {
        switch (browser) {
            case "chrome" -> {
                return new ChromeDriver((ChromeOptions) capabilities);
            }
            case "firefox" -> {
                return new FirefoxDriver((FirefoxOptions) capabilities);
            }
            case "edge" -> {
                return new EdgeDriver((EdgeOptions) capabilities);
            }
            default -> throw new UnsupportedBrowserException(String.format("Unsupported browser %s!", browser));
        }
    }
}
