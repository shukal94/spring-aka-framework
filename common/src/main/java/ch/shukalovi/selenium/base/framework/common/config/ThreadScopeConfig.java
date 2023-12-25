package ch.shukalovi.selenium.base.framework.common.config;

import ch.shukalovi.selenium.base.framework.common.config.postprocessor.ThreadScopeBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadScopeConfig {
    @Bean
    public static ThreadScopeBeanFactoryPostProcessor threadScopeBFPP() {
        return new ThreadScopeBeanFactoryPostProcessor();
    }
}
