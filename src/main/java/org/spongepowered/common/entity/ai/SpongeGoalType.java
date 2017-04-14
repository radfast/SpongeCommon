/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.entity.ai;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.ai.GoalType;

public final class SpongeGoalType implements GoalType {
    private final String id, name;
    private final Class<? extends Goal<?>> goalClass;

    public SpongeGoalType(String id, String name, Class<? extends Goal<?>> goalClass) {
        this.id = id;
        this.name = name;
        this.goalClass = goalClass;
    }

    @Override
    public Class<? extends Goal<?>> getGoalClass() {
        return goalClass;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .addValue(id)
                .addValue(name)
                .add("goalClass", goalClass)
                .toString();
    }
}
