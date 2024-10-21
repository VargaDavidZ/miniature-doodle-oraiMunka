package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BosszualloTest {
    private class BosszualloMock extends Bosszuallo
    {
        public BosszualloMock()
        {
            super(300, true);
        }

        @Override
        public boolean megmentiAVilagot()
        {
            return false;
        }
    }

    Bosszuallo bosszuallo;
    public BosszualloTest()
    {
        bosszuallo = new BosszualloMock();
    }


    @Test
    void getSzuperero() {
        assertEquals(300, bosszuallo.getSzuperero());
    }

    @Test
    void setSzuperero() {
        assertEquals(300, bosszuallo.getSzuperero());
        bosszuallo.setSzuperero(200);
        assertEquals(200, bosszuallo.getSzuperero());
    }

    @Test
    void isVanEGyengesege() {
        assertTrue(bosszuallo.isVanEGyengesege());
    }

    @Test
    void setVanEGyengesege() {
        assertTrue(bosszuallo.isVanEGyengesege());
        bosszuallo.setVanEGyengesege(false);
        assertFalse(bosszuallo.isVanEGyengesege());
    }

    @Test
    void legyoziEBosszuallo() {
        BosszualloMock other = new BosszualloMock();
        assertFalse(bosszuallo.legyoziE(other));
        other.setSzuperero(299);
        assertTrue(bosszuallo.legyoziE(other));
        other.setVanEGyengesege(false);
        assertFalse(bosszuallo.legyoziE(other));
    }

    @Test
    void legyoziEBatman() {
        Batman batman = new Batman();
        assertFalse(bosszuallo.legyoziE(batman));
        bosszuallo.setSzuperero(400);
        assertTrue(bosszuallo.legyoziE(batman));
        bosszuallo.setSzuperero(399);
        assertFalse(bosszuallo.legyoziE(batman));
    }

    @Test
    void megmentiAVilagot()  throws ClassNotFoundException, NoSuchMethodException {
        Method method = Class.forName("hu.petrik.szuperhosprojekt.Bosszuallo").getMethod("megmentiAVilagot");
        assertTrue(Modifier.isAbstract(method.getModifiers()));
    }

    @Test
    void mekkoraAzEreje() {
        assertEquals(bosszuallo.getSzuperero(), bosszuallo.mekkoraAzEreje());
    }

    @Test
    void testToString() {
        assertEquals("Szupererő: 300; van gyengesége", bosszuallo.toString());
        bosszuallo.setSzuperero(200);
        assertEquals("Szupererő: 200; van gyengesége", bosszuallo.toString());
        bosszuallo.setVanEGyengesege(false);
        assertEquals("Szupererő: 200; nincs gyengesége", bosszuallo.toString());
    }

    @Test
    void ImplementsInterfaces()
    {
        assertInstanceOf(Szuperhos.class, bosszuallo);
    }
}