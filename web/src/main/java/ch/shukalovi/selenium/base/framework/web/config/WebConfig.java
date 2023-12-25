package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.common.config.ThreadScopeConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.net.URL;

import static ch.shukalovi.selenium.base.framework.common.util.constant.CommonConstant.THREAD_SCOPE;

// TODO: get rid of imports
@Import({ThreadScopeConfig.class})
@Configuration
public class WebConfig {
    @Value("${web.browser}")
    private String browser;

    @Value("${web.seleniumUrl}")
    private String seleniumUrl;

    private final MutableCapabilities capabilities;

    public WebConfig(MutableCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Bean
    @Scope(scopeName = THREAD_SCOPE)
    @SneakyThrows
    public WebDriver webDriver() {
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        webDriver.setFileDetector(new LocalFileDetector());
        return webDriver;
    }
}
