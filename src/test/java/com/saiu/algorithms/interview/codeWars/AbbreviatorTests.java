package com.saiu.algorithms.interview.codeWars;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem Karnov @date 07.03.17.
 *         artem.karnov@t-systems.com
 */
public class AbbreviatorTests {

    private Abbreviator abbr = new Abbreviator();

    @Test
    public void testInternationalization() {
        assertEquals("i18n", abbr.abbreviate("internationalization"));
    }

//    @Test
//    public void testSentence() {
//        assertEquals("e6t-r3s are r4y fun!", abbr.abbreviate("elephant-rides are really fun!"));
//    }

    /**
     * Test Results:
     testInternationalization(AbbreviatorTests)
     ✘ expected:<i18n[] i19X> but was:<i18n[i18n] i19X>
     testThrowTheKitchenSinkAtEm(AbbreviatorTests)
     ✘ expected:<t[he, the. s2s; b5n-on. s2s, d4e-b6d's2s'd4]e-b6d> but was:<t[2, t2. s3; b5n-on. s3, d4e-b18]e-b6d>
     testLongSentence(AbbreviatorTests)
     ✘ expected:<You n[2d, n2d not w2t], to c6e t2s c2e-w2s...> but was:<You n[3, n2d not w3], to c6e t2s c2e-w2s...>
     testAccessibility(AbbreviatorTests)
     ✔ Test Passed
     testAccessibilityCaps(AbbreviatorTests)
     ✔ Test Passed
     Completed in 69.218259 ms
     */

}