package de.illilli.kulturpfade.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnchorTypeTest {

    @Test
    public void testIsUnanchored() {

        String input = "b09-t01-u01-0.1";
        assertTrue(AnchorType.isUnanchored(input));

    }

    @Test
    public void testIsNotUnanchored() {

        String input = "b09-t01-p01-0.1";
        assertTrue(!AnchorType.isUnanchored(input));

    }

    @Test
    public void testIsBase() {

        String input = "b09-t01-s01-0.1";
        assertTrue(AnchorType.isBase(input));

    }

    @Test
    public void testIsNotBase() {

        String input = "b09-t01-p01-0.1";
        assertTrue(!AnchorType.isBase(input));

    }

    @Test
    public void testIsAnchor() {

        String input = "b09-t01-p01-0.1";
        assertTrue(AnchorType.isAnchor(input));

    }

    @Test
    public void testIsNotAnchor() {

        String input = "b09-t01-s01-0.1";
        assertTrue(!AnchorType.isAnchor(input));

    }

}
