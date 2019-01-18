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

import be.yildizgames.common.model.Version.VersionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class VersionTest {

    @Test
    void testVersionMajor() {
        assertThrows(IllegalArgumentException.class, () -> new Version(VersionType.RELEASE, -1, 1, 1, 0));
    }

    @Test
    void testVersionMinor() {
        assertThrows(IllegalArgumentException.class, () -> new Version(VersionType.RELEASE, 1, -1, 1, 0));
    }

    @Test
    void testVersionSub() {
        assertThrows(IllegalArgumentException.class, () -> new Version(VersionType.RELEASE, 1, 1, -1, 0));
    }

    @Test
    void testVersionRev() {
        assertThrows(IllegalArgumentException.class, () -> new Version(VersionType.RELEASE, 1, 1, 1, -1));
    }

    @Test
    void testGetMajor() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(i1, v.getMajor());
    }

    @Test
    void testGetMinor() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(i2, v.getMinor());
    }

    @Test
    void testGetSub() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(i3, v.getSub());
    }

    @Test
    void testGetRev() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(r, v.getRev());
    }

    @Test
    void testEqualsObject() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        Version v2 = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(v, v2);
        v2 = new Version(VersionType.RELEASE, i3, i1, i2, r);
        BaseTest<Version> b = new BaseTest<>(v, new Version(VersionType.RELEASE, i1, i2, i3, r), v2);
        b.all();
        assertNotEquals(v, new Version(VersionType.ALPHA, i1, i2, i3, r));
        assertNotEquals(v, new Version(VersionType.RELEASE, i1 + 1, i2, i3, r));
        assertNotEquals(v, new Version(VersionType.RELEASE, i1, i2 + 1, i3, r));
        assertNotEquals(v, new Version(VersionType.RELEASE, i1, i2, i3 + 1, r));
        assertNotEquals(v, new Version(VersionType.RELEASE, i1, i2, i3, r + 1));
    }

    @Test
    void testHashCode() {
        final Integer i1 = 1;
        final Integer i2 = 2;
        final Integer i3 = 3;
        final int r = 5;
        final Version v1 = new Version(VersionType.RELEASE, i1, i2, i3, r);
        final Version v2 = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals(v1.hashCode(), v2.hashCode());
    }

    @Test
    void testToString() {
        final int i1 = 1;
        final int i2 = 2;
        final int i3 = 3;
        final int r = 5;
        final Version v = new Version(VersionType.RELEASE, i1, i2, i3, r);
        assertEquals("RELEASE 1.2.3_5", v.toString());
    }

    @Test
    void testGetType() {
        assertEquals(VersionType.RELEASE, new Version(VersionType.RELEASE, 0, 0, 0, 0).getType());
        assertEquals(VersionType.BETA, new Version(VersionType.BETA, 0, 0, 0, 0).getType());
        assertEquals(VersionType.ALPHA, new Version(VersionType.ALPHA, 0, 0, 0, 0).getType());
    }

    @Test
    void valueOf() {
        assertEquals(VersionType.ALPHA, VersionType.valueOf(0));
        assertEquals(VersionType.BETA, VersionType.valueOf(1));
        assertEquals(VersionType.RELEASE, VersionType.valueOf(2));
    }

    @Test
    void invalidValueOf() {
        assertThrows(IllegalArgumentException.class, () -> VersionType.valueOf(3));
    }

    @Test
    void testAlphaConstructor() {
        Version v = Version.alpha(1,2,3,4);
        assertEquals(VersionType.ALPHA, v.getType());
        assertEquals(1, v.getMajor());
        assertEquals(2, v.getMinor());
        assertEquals(3, v.getSub());
        assertEquals(4, v.getRev());
    }

    @Test
    void testBetaConstructor() {
        Version v = Version.beta(1,2,3,4);
        assertEquals(VersionType.BETA, v.getType());
        assertEquals(1, v.getMajor());
        assertEquals(2, v.getMinor());
        assertEquals(3, v.getSub());
        assertEquals(4, v.getRev());
    }

    @Test
    void testReleaseConstructor() {
        Version v = Version.release(1,2,3,4);
        assertEquals(VersionType.RELEASE, v.getType());
        assertEquals(1, v.getMajor());
        assertEquals(2, v.getMinor());
        assertEquals(3, v.getSub());
        assertEquals(4, v.getRev());
    }
}
