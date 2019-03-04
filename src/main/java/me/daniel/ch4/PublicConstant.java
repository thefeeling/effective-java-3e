package me.daniel.ch4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Thing {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


public class PublicConstant {
    private static final Thing[] thingsArr = { new Thing() };
    public static final List<Thing> thingsList = Collections.unmodifiableList(Arrays.asList(thingsArr));
    public static final Thing[] getThings() {
        return thingsArr.clone();
    }
}