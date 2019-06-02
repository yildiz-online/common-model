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

import java.util.HashMap;
import java.util.Map;

/**
 * An id represent an unique instance of a class of object. The same id can be shared between different class but two objects of the same class cannot have the same id.
 *
 * @author Grégory Van den Borre
 */
public final class WorldId extends ValueObject{

    /**
     * List of all registered id with their value as key.
     */
    private static final Map<Integer, WorldId> LIST = new HashMap<>();

    /**
     * Constant value for the world.
     */
    private static final int WORLD_VALUE = 0;
    
    /**
     * Constant id for the world.
     */
    public static final WorldId WORLD = new WorldId(WorldId.WORLD_VALUE);

    /**
     * Full constructor, private to prevent use, to create an id, retrieve it from Id.get.
     *
     * @param idValue Initialize the wrapped value.
     */
    private WorldId(final int idValue) {
        super(idValue);
        WorldId.LIST.putIfAbsent(idValue, this);
    }

    /**
     * Retrieve an Id from a value.
     *
     * @param value Id value to get, positive and negative values are allowed, -1 is WORLD.
     * @return The Id with the internal value correspond to the parameter.
     */
    public static WorldId valueOf(final int value) {
        if (!WorldId.LIST.containsKey(value)) {
            WorldId.LIST.put(value, new WorldId(value));
        }
        return WorldId.LIST.get(value);
    }

    /**
     * Check if an id is world.
     *
     * @param id Id to check.
     * @return <code>true</code> if Id matches world Id.
     */
    public static boolean isWorld(final WorldId id) {
        ImplementationException.throwForNull(id);
        return id.value == WorldId.WORLD_VALUE;
    }

    /**
     * Check if an id is world.
     *
     * @param id Internal value to check.
     * @return <code>true</code> if the internal value matches world internal value.
     */
    public static boolean isWorld(final long id) {
        return id == WorldId.WORLD_VALUE;
    }

    /**
     * @return <code>true</code> if id value is lower than 0.
     */
    public final boolean isNegative() {
        return this.value < 0;
    }

    /**
     * Check if this is world.
     *
     * @return <code>true</code> if this id is world.
     */
    public final boolean isWorld() {
        return this.value == WorldId.WORLD_VALUE;
    }
}
