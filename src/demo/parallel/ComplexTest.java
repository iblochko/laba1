package demo.parallel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void testMag() {
        Complex c1 = new Complex(3, 4); // 3 + 4i
        assertEquals(5.0, c1.mag(), 1e-9); // sqrt(9+16)=5

        Complex c2 = new Complex(0, 0);
        assertEquals(0.0, c2.mag(), 1e-9);

        Complex c3 = new Complex(5, 0);
        assertEquals(5.0, c3.mag(), 1e-9);

        Complex c4 = new Complex(0, -7);
        assertEquals(7.0, c4.mag(), 1e-9);
    }

    @Test
    void testArg() {
        Complex c1 = new Complex(1, 0);
        assertEquals(0.0, c1.arg(), 1e-9);

        Complex c2 = new Complex(0, 1);
        assertEquals(Math.PI / 2, c2.arg(), 1e-9);

        Complex c3 = new Complex(-1, 0);
        assertEquals(Math.PI, c3.arg(), 1e-9);

        Complex c4 = new Complex(0, -1);
        assertEquals(-Math.PI / 2, c4.arg(), 1e-9);
    }

    @Test
    void testPowIntegerExponent() {
        Complex c = new Complex(1, 1); // √2 * e^(iπ/4)

        Complex result = c.pow(2); // должно быть (1+i)^2 = 2i
        assertEquals(0.0, result.getRe(), 1e-9);
        assertEquals(2.0, result.getIm(), 1e-9);

        Complex result3 = c.pow(3); // (1+i)^3 = -2+2i
        assertEquals(-2.0, result3.getRe(), 1e-9);
        assertEquals(2.0, result3.getIm(), 1e-9);
    }

    @Test
    void testPowNonIntegerExponent() {
        Complex c = new Complex(0, 1); // i

        Complex result = c.pow(0.5); // sqrt(i) = (√2/2) + i(√2/2)
        assertEquals(Math.sqrt(2) / 2, result.getRe(), 1e-9);
        assertEquals(Math.sqrt(2) / 2, result.getIm(), 1e-9);
    }
}
