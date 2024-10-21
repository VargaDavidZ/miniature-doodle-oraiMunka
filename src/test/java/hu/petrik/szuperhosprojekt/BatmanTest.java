package hu.petrik.szuperhosprojekt;

import org.junit.jupiter.api.Test;

class BatmanTest {
    private class SzuperhosMock implements Szuperhos
    {
        @Override
        public boolean legyoziE(Szuperhos szuperhos)
        {
            return false;
        }

        @Override
        public double mekkoraAzEreje()
        {
            return 300;
        }
    }
    Batman batman;
    public BatmanTest() {
        batman = new Batman();
    }

    @Test
    void Batman()
    {
        assertEquals(200, batman.mekkoraAzEreje());
    }

    @Test
    void kutyutKeszit() {
        batman.kutyutKeszit();
        assertEquals(300, batman.mekkoraAzEreje());
    }

    @Test
    void legyoziE() {
        assertFalse(batman.legyoziE(new SzuperhosMock()));
        batman.kutyutKeszit();
        batman.kutyutKeszit();
        batman.kutyutKeszit();
        batman.kutyutKeszit();
        assertFalse(batman.legyoziE(new SzuperhosMock()));
        batman.kutyutKeszit();
        assertTrue(batman.legyoziE(new SzuperhosMock()));
    }

    @Test
    void mekkoraAzEreje() {
        assertEquals(200, batman.mekkoraAzEreje());
        batman.kutyutKeszit();
        assertEquals(300, batman.mekkoraAzEreje());
    }

    @Test
    void testToString() {
        assertEquals("Batman: leleményesség: 100", batman.toString());
        batman.kutyutKeszit();
        assertEquals("Batman: leleményesség: 150", batman.toString());
    }
}