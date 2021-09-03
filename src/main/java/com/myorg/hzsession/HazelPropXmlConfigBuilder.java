package com.myorg.hzsession;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Properties;

public class HazelPropXmlConfigBuilder {

    public void setHazelProperties() {
        Properties properties = new Properties();

// fill the properties, e.g., from database/LDAP, etc.

        XmlConfigBuilder builder = new XmlConfigBuilder();
        builder.setProperties(properties);
        Config config = builder.build();
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
    }
}
