package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class MilliardosTest {

    @Test
    void interfaceMethods() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> c = Class.forName("hu.petrik.szuperhosprojekt.Milliardos");
        assertTrue(Modifier.isInterface(c.getModifiers()));
        assertTrue(Modifier.isAbstract(c.getMethod("kutyutKeszit").getModifiers()));
    }
}