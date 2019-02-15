package com.nbc.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:test.properties" })
public interface Configuration extends Config {

    int timeout();

    int implicitWait();

    String host();

    String driver();

}