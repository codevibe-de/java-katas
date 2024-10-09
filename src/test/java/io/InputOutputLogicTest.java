package io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.Base64;

public class InputOutputLogicTest {

    @Test
    void correctlyEncoded() {
        byte[] bytes = InputOutputLogic.encodeAsUtf8("20 £");
        Assertions.assertThat(bytes).hasSize(5);
        Assertions.assertThat(bytesToHex(bytes)).isEqualTo("32 30 20 C2 A3");
    }


    @Test
    void constructUtf8Bytes() {
        var expectedAsBase64 = "NjEgNjIgNjMgMjAgQzMgQTQgMjAgRTIgODIgQUM=";
        var actualAsHex = InputOutputLogic.getHexString().toUpperCase();
        var actualAsBase64 = Base64.getEncoder().encodeToString(actualAsHex.getBytes());
        Assertions.assertThat(actualAsBase64).isEqualTo(expectedAsBase64);
    }


    /**
     * This test always succeeds but prints the decoded secret to stdout.
     */
    @Test
    void decode() {
        var bytes = new byte[]{-2, -1, 0, 82, 0, 105, 0, 101, 0, 115, 0, 101, 0, 110, 0, 98, 0, 114, 0, 101, 0, 122, 0, 101, 0, 108};
        Charset charset = InputOutputLogic.getCharset();
        var decoded = new String(bytes, charset);
        System.out.println(decoded);
    }


    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
