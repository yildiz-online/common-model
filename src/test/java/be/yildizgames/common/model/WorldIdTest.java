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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
class WorldIdTest {

    @Nested
    class IsWorld {

        @Test
        void happyFlow() {
            assertTrue(WorldId.valueOf(0).isWorld());
        }

        @Test
        void notWorld() {
            assertFalse(WorldId.valueOf(1).isWorld());
        }
    }

    @Nested
    class IsWorldId {

        @Test
        void happyFlow() {
            assertTrue(WorldId.isWorld(WorldId.valueOf(0)));
        }

        @Test
        void wrongValue() {
            assertFalse(WorldId.isWorld(WorldId.valueOf(1)));
        }

        @Test
        void withNull() {
            assertThrows(ImplementationException.class, () -> WorldId.isWorld(null));
        }
    }

    @Nested
    class IsWorldLong {

        @Test
        void happyFlow() {
            assertTrue(WorldId.isWorld(0));
        }

        @Test
        void wrongValue() {
            assertFalse(WorldId.isWorld(1));
        }
    }

    @Nested
    class IsNegative {

        @Test
        void happyFlow() {
            assertTrue(WorldId.valueOf(-1).isNegative());
        }

        @Test
        void wrongValue() {
            assertFalse(WorldId.valueOf(1).isNegative());
        }

        @Test
        void zero() {
            assertFalse(WorldId.valueOf(0).isNegative());
        }
    }
}
