package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class SzuperhosTest {

    @Test
    void interfaceMethods() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> c = Class.forName("hu.petrik.szuperhosprojekt.Szuperhos");
        assertTrue(Modifier.isInterface(c.getModifiers()));

        assertTrue(Modifier.isAbstract(c.getMethod("legyoziE", Szuperhos.class).getModifiers()));
        assertTrue(Modifier.isAbstract(c.getMethod("mekkoraAzEreje").getModifiers()));
    }
}