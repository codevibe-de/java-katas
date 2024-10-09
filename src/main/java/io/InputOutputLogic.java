package io;

import java.nio.charset.StandardCharsets;

public class InputOutputLogic {

    public static byte[] encodeAsUtf8(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

}
