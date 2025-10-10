package com.saddy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog {
    private static final Logger logger = LogManager.getLogger(DemoLog.class);

    static void main() {
        logger.info("First line of the method");
        greet("Saddam");
    }

    static void greet(String name) {
        logger.info("Hello, " + name);
    }
}
