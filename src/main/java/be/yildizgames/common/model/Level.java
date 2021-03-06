/*
 * MIT License
 *
 * Copyright (c) 2019 Grégory Van den Borre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package be.yildizgames.common.model;

/**
 * Simple wrapper class to represent level.
 * Immutable class.
 *
 * @author Grégory Van den Borre
 */
public final class Level extends ValueObject {


    /**
     * Constant for 0.
     */
    public static final Level ZERO = new Level(0);

    /**
     * Constant for 1.
     */
    public static final Level ONE = new Level(1);

    /**
     * Full constructor.
     *
     * @param level Level value.
     */
    private Level(final int level) {
        super(level);
        if(level < 0) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
    }

    public static Level valueOf(int level) {
        return new Level(level);
    }

    /**
     * Create a new Level base on the result of this one added to a value.
     *
     * @param toAdd Value to add to this level to get the new one.
     * @return A new Level resulting of the sum.
     */
    public Level add(final int toAdd) {
        return new Level(this.value + toAdd);
    }

    public boolean isNotZero() {
        return this.value > 0;
    }
}
