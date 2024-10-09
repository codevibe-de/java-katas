package io;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputOutputLogic {

    /**
     * Convert the given String into an array of bytes using UTF-8 as the charset.
     * See {@link StandardCharsets}
     */
    public static byte[] encodeAsUtf8(String s) {
        return null;
    }


    /**
     * Returns a string of space-separated hex values (e.g. "2A FF 30") that represent
     * the UTF-8 bytes for the text "abc ä €".
     */
    public static String getHexString() {
        return null;
    }


    public static String decodeUsing(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

}
