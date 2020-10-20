
package com.sun.power.core.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 国际化
 *
 * @author 贾涛
 * @since 1.0.0
 */
public class MessageUtils {
//    @Autowired
//    private MessageSource messageSource;
    private static MessageSource messageSource;
    static {
        messageSource = (MessageSource)SpringContextHolder.getBean("messageSource");
    }

    public static String getMessage(int code){
        return getMessage(code, new String[0]);
    }

    public static String getMessage(int code, String... params){
        return messageSource.getMessage(code+"", params, LocaleContextHolder.getLocale());
    }
}
