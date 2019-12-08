package pl.ofnero.day08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {
    @Test
    void shouldCorrectlySplitCodeIntoLayers() {
        List<List<Character>> layers = Arrays.asList(
                Arrays.asList('1', '2', '3', '4', '5', '6'),
                Arrays.asList('7', '8', '9', '0', '1', '2'));
        
        assertEquals(layers, new Decoder().getLayers("123456789012", 3, 2));
    }
}