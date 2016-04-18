package org.butioy.framework.holder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring容器上下文
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-05 21:58
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    //spring容器上下文
    private static ApplicationContext applicationContext;

    /**
     * 自动注入spring上下文对象
     * @param applicationContext spring上下文对象
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 按照 <code>beanName</code> 从spring容器中获取指定的bean对象
     * @param beanName 获取bean的名称
     * @return 获取的bean对象
     */
    public static Object getBean( String beanName ) {
        return applicationContext.getBean( beanName );
    }

    /**
     * 按照 <code>beanName</code> 从spring容器中获取指定类型T的bean对象
     * @param beanName 指定的bean名称
     * @param requiredType 指定的bean类型
     * @return 指定类型的bean对象
     */
    public static <T> T getBean( String beanName, Class<T> requiredType ) {
        return applicationContext.getBean( beanName, requiredType );
    }

    /**
     * 判断spring容器中是否存在名称为 <code>beanName</code> 的bean对象
     * @param beanName 指定的bean名称
     * @return
     *      true:存在
     *      false:不存在
     */
    public static boolean containsBean( String beanName ) {
        return applicationContext.containsBean( beanName );
    }

    /**
     * 判断spring容器中名称为 <code>beanName</code> 的bean对象是否是单例的
     * @param beanName 指定的bean名称
     * @return
     *      true:是
     *      false:不是
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton( String beanName ) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton( beanName );
    }

    /**
     * 从spring容器中获取名称为 <code>beanName</code> 的bean对象的类型
     * @param beanName 指定的bean名称
     * @return spring容器中名称为 <code>beanName</code> 的bean对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public static Class<?> getType( String beanName ) throws NoSuchBeanDefinitionException {
        return applicationContext.getType( beanName );
    }

    /**
     * 从spring容器中获取名称为 <code>beanName</code> 的bean对象的所有别名数组
     * @param beanName 指定的bean名称
     * @return spring容器中名称为 <code>beanName</code> 的bean对象的所有别名数组
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases( String beanName ) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases( beanName );
    }
}
