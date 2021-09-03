package com.myorg.hzsession;

import com.hazelcast.config.replacer.PropertyReplacer;

import java.util.Properties;

public class HazelPropertyReplacer extends PropertyReplacer {
    private Properties systemProperties = new Properties();;

    @Override
    public void init(Properties properties) {
        systemProperties.putAll(System.getenv());

    }

    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public String getReplacement(String properyKey) {
        return systemProperties.getProperty(properyKey);
    }
}
