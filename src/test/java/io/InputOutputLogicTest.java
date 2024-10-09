package io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class InputOutputLogicTest {

    @Test
    void correctlyEncoded() {
        byte[] bytes = InputOutputLogic.encodeAsUtf8("5 €");
        Assertions.assertThat(bytes).hasSize(5);
        Assertions.assertThat(bytesToHex(bytes)).isEqualTo("35 20 E2 82 AC");
    }


    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
