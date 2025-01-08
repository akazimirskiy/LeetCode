package ru.kazimir.leetcode;

import java.util.Optional;

public class Child extends AbstractParent implements Cloneable{
    public String name;
    public Optional<String> str;

    public Child clone() throws CloneNotSupportedException {
        return (Child) super.clone();
    }
}
