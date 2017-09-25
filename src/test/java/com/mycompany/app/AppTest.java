package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testTumArrayYok() {
      String[] str = new String[]{"b","i","l","o","d","e","v"};
      assertTrue(new App().rr(str, 0, 6));
    }

    public void testKismiArrayYok() {
      String[] str2 = new String[]{"b","i","l","o","d","e","v"};
      assertTrue(new App().rr(str2, 3, 5));
    }

    public void testTumArrayRakamVar() {
      String[] str3 = new String[]{"b","i","l","4","8","1","o","d","e","v"};
      assertFalse(new App().rr(str3, 0, 9));
    }

    public void testTumArrayVar() {
      String[] str4 = new String[]{"b","+","l","4","8","*","o","&","e","v"};
      assertFalse(new App().rr(str4, 0, 9));
    }

    public void testNull() {
      assertFalse(new App().rr(null, 0, 12));
    }

}
