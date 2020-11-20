package com.wzg.test.my.shop.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName SpringUtils
 * @Description spring的工具类
 * @Author wzg
 * Date 2020/11/19 14:24
 * Version 1.0
 */
public final class SpringUtils implements ApplicationContextAware, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    private static ApplicationContext applicationContext;

    private SpringUtils() {
    }

    @Override
    public void destroy() throws Exception {
        logger.info("SpringUtils已销毁");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
        logger.info("SpringUtils.applicationContext属性初始化完成");
    }

    public static <T> T getBean(String beanId) {
        if (StringUtils.isBlank(beanId)) {
            return null;
        }
        assert applicationContext==null:"SpringUtils.applicationContext属性初始化失败";
        return (T) applicationContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> clazz) {
        assert applicationContext==null:"SpringUtils.applicationContext属性初始化失败";
        return (T) applicationContext.getBean(clazz);
    }
}
