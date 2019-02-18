package me.daniel.ch2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    @Test
    public void hashCodeTest() {
        short areaCode = 10, prefix = 5, lineNum = 1;
        PhoneNumber p1 = new PhoneNumber(areaCode, prefix, lineNum);
        PhoneNumber p2 = new PhoneNumber(areaCode, prefix, lineNum);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void hashMapTest() {
        short areaCode = 10, prefix = 5, lineNum = 1;
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber p1 = new PhoneNumber(areaCode, prefix, lineNum);
        map.put(p1, "10/5/1");
        assertEquals(map.get(new PhoneNumber(areaCode, prefix, lineNum)), "10/5/1");
    }
}