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
package org.spongepowered.common.world;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import net.minecraft.world.Teleporter;
import org.spongepowered.api.world.PortalAgent;
import org.spongepowered.api.world.PortalAgentType;

public class SpongePortalAgentType implements PortalAgentType {

    private String name;
    private String id;
    private Class<? extends Teleporter> portalAgentClass;

    public SpongePortalAgentType(String name, String id, Class<? extends Teleporter> portalAgentClass) {
        this.name = checkNotNull(name);
        this.id = checkNotNull(id);
        this.portalAgentClass = checkNotNull(portalAgentClass, "The portalAgent class was null! The name was: " + name);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends PortalAgent> getPortalAgentClass() {
        return (Class<? extends PortalAgent>) this.portalAgentClass;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("class", this.portalAgentClass.getName())
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PortalAgentType)) {
            return false;
        }

        PortalAgentType other = (PortalAgentType) obj;
        return this.name.equalsIgnoreCase(other.getName()) && this.portalAgentClass.equals(other.getPortalAgentClass());

    }

    @Override
    public int hashCode() {
        return super.hashCode(); // todo this is a warning
    }
}
