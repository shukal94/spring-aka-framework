package ch.shukalovi.selenium.base.framework.web.config;

import ch.shukalovi.selenium.base.framework.common.config.ThreadScopeConfig;
import ch.shukalovi.selenium.base.framework.web.config.timeouts.TimeoutProperties;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static ch.shukalovi.selenium.base.framework.common.util.constant.CommonConstant.THREAD_SCOPE;

// TODO: get rid of imports
@Import({ThreadScopeConfig.class})
@Configuration
@EnableConfigurationProperties({TimeoutProperties.class})
public class WebConfig {
    @Value("${web.seleniumUrl}")
    private String seleniumUrl;

    private final Capabilities capabilities;

    public WebConfig(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    // TODO: why my caps and timeouts are not visible?
    @Bean
    @Scope(scopeName = THREAD_SCOPE)
    @SneakyThrows
    public WebDriver webDriver(TimeoutProperties timeoutProperties) {
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        webDriver.setFileDetector(new LocalFileDetector());

        WebDriver.Timeouts timeouts = webDriver.manage().timeouts();
        timeouts.scriptTimeout(Duration.of(timeoutProperties.getScriptTimeout(), ChronoUnit.SECONDS));
        timeouts.pageLoadTimeout(Duration.of(timeoutProperties.getPageLoadTimeout(), ChronoUnit.SECONDS));
        timeouts.implicitlyWait(Duration.of(timeoutProperties.getImplicitTimeout(), ChronoUnit.SECONDS));

        return webDriver;
    }
}
