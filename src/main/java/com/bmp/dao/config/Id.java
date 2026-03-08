package com.bmp.dao.config;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

import com.google.common.primitives.Longs;

public final class Id implements Serializable, Comparable<Id> {
    private static final long serialVersionUID = 3235099421421687350L;
    private static final Random RND = new SecureRandom();
    private static final long LONG_SIGNED_BITS = 0x7fffffffffffffL;

    private long id;
    
    private Id(final long id) {
        this.id = id;
    }

    public static Id next() {
        return new Id(nextLong());
    }

    public static long nextLong() {
        // Removed signed bit to ensure only positive numbers
        return LONG_SIGNED_BITS & RND.nextLong();
    }

    private long getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Id id1 = (Id) o;
        return id == id1.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public int compareTo(final Id other) {
        return other == null ? 1 : Longs.compare(id, other.getId());
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}