package com.ntyx.edu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: leyou_99
 * @description:
 **/
@Data
@Component
@ConfigurationProperties("ly.filter")
public class AllowPathProperties {

    private List<String> allowPaths;

}
