package com.myorg.hzsession;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelClientIntfImpl {

    private HazelClientIntfImpl() {

    }

    public static HazelcastInstance getInstance() {
        Config cfg = new Config();
        cfg.setInstanceName("wc-instance");
        cfg.setClusterName(System.getProperty("cluster.name"));
        cfg.getNetworkConfig().getJoin().getMulticastConfig().setMulticastGroup("224.2.2.4");
        HazelcastInstance instance = Hazelcast.getOrCreateHazelcastInstance(cfg);
        return  instance;
    }
}
