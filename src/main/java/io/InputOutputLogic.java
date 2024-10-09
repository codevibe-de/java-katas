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
     *
     * @see <a href="https://www.utf8-zeichentabelle.de/unicode-utf8-table.pl">char table</a>
     *
     * NOTE the linked page above allows to SWITCH THE BLOCK of characters! You will also need "Currency symbols"!!!
     */
    public static String getHexString() {
        return null;
    }


    public static Charset getCharset() {
        return null;
    }

}
