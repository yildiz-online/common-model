/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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


import be.yildizgames.common.exception.implementation.ImplementationException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grégory Van den Borre
 */
public class PlayerIdTest {

    @Nested
    public class ValueOf {

        @Test
        public void happyFlow() {
            PlayerId id = PlayerId.valueOf(5);
            assertEquals(5, id.value);
        }
    }

    @Nested
    public class IsWorld {

        @Test
        public void worldValue() {
            PlayerId id = PlayerId.valueOf(0);
            assertTrue(id.isWorld());
        }

        @Test
        public void wrongValue() {
            PlayerId id = PlayerId.valueOf(5);
            assertFalse(id.isWorld());
        }

        @Test
        public void worldConstant() {
            PlayerId id = PlayerId.WORLD;
            assertTrue(id.isWorld());
        }

        @Test
        public void wrongIntParam() {
            assertFalse(PlayerId.isWorld(1));
        }

        @Test
        public void worldIntParam() {
            assertTrue(PlayerId.isWorld(0));
        }

        @Test
        public void wrongIdParam() {
            assertFalse(PlayerId.isWorld(PlayerId.valueOf(2)));
        }

        @Test
        public void worldIdParam() {
            assertTrue(PlayerId.isWorld(PlayerId.valueOf(0)));
        }

        @Test
        public void nullIdParam() {
            assertThrows(ImplementationException.class, () -> PlayerId.isWorld(null));
        }
    }

    @Nested
    public class IsNegative {

        @Test
        public void negative() {
            assertTrue(PlayerId.valueOf(-1).isNegative());
        }

        @Test
        public void positive() {
            assertFalse(PlayerId.valueOf(1).isNegative());
        }

        @Test
        public void zero() {
            assertFalse(PlayerId.valueOf(0).isNegative());
        }

    }
}
