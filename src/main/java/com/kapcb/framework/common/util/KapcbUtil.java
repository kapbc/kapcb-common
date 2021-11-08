package com.kapcb.framework.common.util;

import com.kapcb.framework.common.constants.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;

/**
 * <a>Title: KapcbUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: KapcbUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 20:48
 */
@Slf4j
@UtilityClass
public class KapcbUtil {

    public static void serverStartUpBanner(Environment environment) {
        String banner = "\n----------------------------------------------------------------------------------\n" +
                "server start success, current time is : " + LocalDateTime.now() + "\n" +
                "server name : " + environment.getProperty(StringPool.SERVER_APPLICATION_NAME.value()) + "\n" +
                "server port : " + environment.getProperty(StringPool.SERVER_PORT.value()) + "\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }

    public static void serverShutDownHookBanner() {
        String banner = "\n----------------------------------------------------------------------------------\n" +
                "--------------------------< Kapcb Application Shut Down >-------------------------\n" +
                "-----< No Matter How High The Mountain Is, One Can Always Ascend To It‘s Top >----\n" +
                "----------------------------------< Kapcb >---------------------------------------\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }

}
