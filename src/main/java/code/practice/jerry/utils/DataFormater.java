package code.practice.jerry.utils;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.spi.DataFormat;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class DataFormater {

    private DataFormater() {

    }

    public static DataFormat format(Class<?> type) {
        JacksonDataFormat dataFormat = new JacksonDataFormat(type);
        dataFormat.setInclude("NON_NULL");
        dataFormat.enableFeature(FAIL_ON_UNKNOWN_PROPERTIES);
        return dataFormat;
    }
}
