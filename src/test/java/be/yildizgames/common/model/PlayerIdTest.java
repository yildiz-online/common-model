/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.model;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
class PlayerIdTest {

    @Nested
    class ValueOf {

        @Test
        void happyFlow() {
            PlayerId id = PlayerId.valueOf(5);
            assertEquals(5, id.value);
        }
    }

    @Nested
    class IsWorld {

        @Test
        void worldValue() {
            PlayerId id = PlayerId.valueOf(0);
            assertTrue(id.isWorld());
        }

        @Test
        void wrongValue() {
            PlayerId id = PlayerId.valueOf(5);
            assertFalse(id.isWorld());
        }

        @Test
        void worldConstant() {
            PlayerId id = PlayerId.WORLD;
            assertTrue(id.isWorld());
        }

        @Test
        void wrongIntParam() {
            assertFalse(PlayerId.isWorld(1));
        }

        @Test
        void worldIntParam() {
            assertTrue(PlayerId.isWorld(0));
        }

        @Test
        void wrongIdParam() {
            assertFalse(PlayerId.isWorld(PlayerId.valueOf(2)));
        }

        @Test
        void worldIdParam() {
            assertTrue(PlayerId.isWorld(PlayerId.valueOf(0)));
        }

        @Test
        void nullIdParam() {
            assertThrows(AssertionError.class, () -> PlayerId.isWorld(null));
        }
    }

    @Nested
    class IsNegative {

        @Test
        void negative() {
            assertTrue(PlayerId.valueOf(-1).isNegative());
        }

        @Test
        void positive() {
            assertFalse(PlayerId.valueOf(1).isNegative());
        }

        @Test
        void zero() {
            assertFalse(PlayerId.valueOf(0).isNegative());
        }

    }

    @Nested
    class HashCode {

        @Test
        void happyFlow() {
            assertEquals(-5, PlayerId.valueOf(-5).hashCode());
        }
    }

    @Nested
    class Equals {

        @Test
        void happyFlow() {
            PlayerId id = PlayerId.valueOf(5);
            PlayerId id2 = PlayerId.valueOf(5);
            assertTrue(id.equals(id2));
        }

        @Test
        void sameObject() {
            PlayerId id = PlayerId.valueOf(5);
            assertTrue(id.equals(id));
        }


        @Test
        void notSame() {
            PlayerId id = PlayerId.valueOf(5);
            PlayerId id2 = PlayerId.valueOf(6);
            assertFalse(id.equals(id2));
        }

        @Test
        void otherType() {
            PlayerId id = PlayerId.valueOf(5);
            assertFalse(id.equals("ok"));
        }

        @Test
        void withNull() {
            PlayerId id = PlayerId.valueOf(5);
            assertFalse(id.equals(null));
        }
    }

    @Nested
    class ToString {

        @Test
        void happyFlow() {
            assertEquals("-5", PlayerId.valueOf(-5).toString());
        }
    }
}
