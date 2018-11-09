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

import be.yildizgames.common.exception.implementation.ImplementationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Grégory Van den Borre
 */
class ActionIdTest {

    @Nested
    class Get {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(1000);
            Assertions.assertNotNull(id);
            assertEquals(1000, id.value);
        }

        @Test
        void cached() {
            ActionId id = ActionId.valueOf(2000);
            ActionId id2 = ActionId.valueOf(2000);
            Assertions.assertTrue(id == id2);
        }
    }

    @Nested
    class ValueOf {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(1000);
            Assertions.assertNotNull(id);
            assertEquals(1000, id.value);
        }

        @Test
        void cached() {
            ActionId id = ActionId.valueOf(2000);
            ActionId id2 = ActionId.valueOf(2000);
            Assertions.assertTrue(id == id2);
        }
    }

    @Nested
    class IsWorld {

        @Test
        void happyFlow() {
            ActionId id = ActionId.WORLD;
            assertTrue(id.isWorld());
        }

        @Test
        void not() {
            ActionId id = ActionId.valueOf(5);
            assertFalse(id.isWorld());
        }

        @Test
        void fromId() {
            assertTrue(ActionId.isWorld(ActionId.WORLD));
        }

        @Test
        void fromInt() {
            assertTrue(ActionId.isWorld(ActionId.WORLD.value));
        }

        @Test
        void fromIdNot() {
            assertFalse(ActionId.isWorld(ActionId.valueOf(2)));
        }

        @Test
        void fromIdNull() {
            Assertions.assertThrows(ImplementationException.class, () -> ActionId.isWorld(null));
        }

        @Test
        void fromIntNot() {
            assertFalse(ActionId.isWorld(4));
        }
    }

    @Nested
    class IsNegative {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(-1);
            assertTrue(id.isNegative());
        }

        @Test
        void not() {
            ActionId id = ActionId.valueOf(5);
            assertFalse(id.isNegative());
        }
    }

    @Nested
    class HashCode {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(5);
            ActionId id2 = ActionId.valueOf(5);
            assertEquals(id.hashCode(), id2.hashCode());
        }
    }

    @Nested
    class Equals {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(5);
            ActionId id2 = ActionId.valueOf(5);
            assertEquals(id, id2);
        }

        @Test
        void notSame() {
            ActionId id = ActionId.valueOf(5);
            ActionId id2 = ActionId.valueOf(6);
            Assertions.assertNotEquals(id, id2);
        }
    }

    @Nested
    class ToString {

        @Test
        void happyFlow() {
            ActionId id = ActionId.valueOf(8);
            assertEquals("8", id.toString());
        }
    }
}
