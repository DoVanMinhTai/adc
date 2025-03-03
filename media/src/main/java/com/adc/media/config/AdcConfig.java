package com.adc.media.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "adc")
public record AdcConfig(String url) {
}
