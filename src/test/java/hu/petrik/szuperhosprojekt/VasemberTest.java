package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VasemberTest {
    Vasember vasember;

    public VasemberTest()
    {
        vasember = new Vasember();
    }

    @Test
    void Vasember()
    {
        assertEquals(150, vasember.getSzuperero());
        assertTrue(vasember.isVanEGyengesege());
    }

    @Test
    void kutyutKeszit()
    {
        for (int i = 0; i < 10000; i++)
        {
            double szuperero = vasember.getSzuperero();
            vasember.kutyutKeszit();
            assertEquals(szuperero + 5, vasember.getSzuperero(), 5.0);
        }
    }

    @Test
    void megmentiAVilagot()
    {
        assertFalse(vasember.megmentiAVilagot());
        vasember.setSzuperero(1000);
        assertFalse(vasember.megmentiAVilagot());
        vasember.setSzuperero(1001);
        assertTrue(vasember.megmentiAVilagot());
    }

    @Test
    void testToString()
    {
        assertEquals("Vasember: Szupererő: 150; van gyengesége", vasember.toString());
        vasember.setSzuperero(200);
        assertEquals("Vasember: Szupererő: 200; van gyengesége", vasember.toString());
        vasember.setVanEGyengesege(false);
        assertEquals("Vasember: Szupererő: 200; nincs gyengesége", vasember.toString());
    }

    @Test
    void implementsInterfaces()
    {
        assertInstanceOf(Szuperhos.class, vasember);
        assertInstanceOf(Milliardos.class, vasember);
        assertInstanceOf(Bosszuallo.class, vasember);
    }
}