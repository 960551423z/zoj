package com.camellia.zoj.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午3:19
 * Swagger 相关配置
 */

@Data
@Component
@ConfigurationProperties(prefix = "zoj.swagger")
public class SwaggerProperties implements Serializable {

    public String swaggerPath;

    public String title;

    public String description;

    public String contactName;

    public String contactEmail;

    public String url;
}
