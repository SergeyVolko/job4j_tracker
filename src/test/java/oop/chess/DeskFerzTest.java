package oop.chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeskFerzTest  {

    @Test
    public void isPut() {
        DeskFerz deskFerz = new DeskFerz(new int[]{1, 7, 4, -1, -1});
        assertTrue(deskFerz.isPut(2));
    }
}