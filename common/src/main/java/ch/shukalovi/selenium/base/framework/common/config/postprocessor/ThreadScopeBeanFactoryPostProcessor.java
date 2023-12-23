package ch.shukalovi.selenium.base.framework.common.config.postprocessor;

import ch.shukalovi.selenium.base.framework.common.util.constant.CommonConstant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.SimpleThreadScope;

public class ThreadScopeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(CommonConstant.THREAD_SCOPE, new SimpleThreadScope());
    }
}
