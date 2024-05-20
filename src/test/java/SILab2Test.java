import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void everyBranchTest() {
        // 1
        List<Item> allItems1 = null;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems1, 100));

        // 2
        Item itemCase2 = new Item(null, "2A45", 100, 0);
        List<Item> allItems2 = List.of(itemCase2);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems2, 200));

        // 3
        Item itemCase3 = new Item("random", null, 100, 0);
        List<Item> allItems3 = List.of(itemCase3);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems3, 300));

        // 4
        Item item1Case4 = new Item("random1", "1234", 100, 0);
        Item item2Case4 = new Item("random2", "0123", 350, (float) 0.15);
        List<Item> allItems4 = List.of(item1Case4, item2Case4);
        assertTrue(SILab2.checkCart(allItems4, 500));

        // 5
        Item item1Case5 = new Item("random1", "1234", 100, 0);
        Item item2Case5 = new Item("random2", "0123", 350, (float) 0.15);
        List<Item> allItems5 = List.of(item1Case5, item2Case5);
        assertFalse(SILab2.checkCart(allItems5, 0));

    }

    @Test
    void multipleConditionTest() {
        // THE IF CONDITIONS IN FOR LOOPS ARE NOT EXPLICITLY WRITTEN AS SEPARATE TEST CASES
        // BECAUSE THEY ARE IMPLICITLY IN NEARLY ALL ASSERTS BELOW

        RuntimeException ex;

        // A - NODE TEST CASES - 1
        // [A:T]
        List<Item> allItems11 = null;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems11, 100));
        assertTrue(ex.getMessage().contains("llItems list can't be null!"));

        // [A:F]
        Item itemCase1 = new Item(null, "1234", 100, (float) 0.15);
        List<Item> allItems12 = List.of(itemCase1);
        assertTrue(SILab2.checkCart(allItems12, 500));

        // F - NODE TEST CASES - 2
        // [F:TX]
        Item itemCase21 = new Item(null, "1234", 100, (float) 0.15);
        List<Item> allItems21 = List.of(itemCase21);
        assertTrue(SILab2.checkCart(allItems21, 500));

        // [F:FT]
        Item itemCase22 = new Item("", "1234", 100, (float) 0.15);
        List<Item> allItems22 = List.of(itemCase22);
        assertTrue(SILab2.checkCart(allItems22, 500));

        // [F:FF]
        Item itemCase23 = new Item("Peter", "1234", 100, (float) 0.15);
        List<Item> allItems23 = List.of(itemCase23);
        assertTrue(SILab2.checkCart(allItems23, 500));

        // H - NODE TEST CASES - 3
        // [H:T]
        Item itemCase31 = new Item("default", "1234", 100, 0);
        List<Item> allItems31 = List.of(itemCase31);
        assertTrue(SILab2.checkCart(allItems31, 500));

        // [H:F]
        Item itemCase32 = new Item("default", null, 100, 0);
        List<Item> allItems32 = List.of(itemCase32);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems32, 100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        // LM - NODE TEST CASES - 4
        // [LM:T] && [LM:F] - kje se dobie true i false so 1 test case bidejki e loop
        Item itemCase41 = new Item("default", "2A34", 100, 0);
        List<Item> allItems41 = List.of(itemCase41);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems41, 100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        // O - NODE TEST CASES - 5
        // [O:T] && [O:F] - kje se dobie true i false so 1 test case bidejki e loop i listata e so 2 el
        Item itemCase51 = new Item("default", "1234", 200, 0);
        Item itemCase52 = new Item("default", "1234", 200, (float)0.15);
        List<Item> allItems51 = List.of(itemCase51, itemCase52);
        assertTrue(SILab2.checkCart(allItems51, 500));

        // S - NODE TEST CASES - 6
        // [S:FXX]
        Item itemCase61 = new Item("default", "1234", 250, 0);
        List<Item> allItems61 = List.of(itemCase61);
        assertTrue(SILab2.checkCart(allItems51, 500));

        // [S:TFX]
        Item itemCase62 = new Item("default", "1234", 350, 0);
        List<Item> allItems62 = List.of(itemCase62);
        assertTrue(SILab2.checkCart(allItems62, 500));

        // [S:TTF]
        Item itemCase63 = new Item("default", "1234", 350, (float)0.15);
        List<Item> allItems63 = List.of(itemCase63);
        assertTrue(SILab2.checkCart(allItems63, 500));

        // [S:TTT]
        Item itemCase65 = new Item("default", "0234", 350, (float)0.15);
        List<Item> allItems65 = List.of(itemCase65);
        assertTrue(SILab2.checkCart(allItems65, 500));

        // U - NODE TEST CASES - 7
        // [U:T]
        Item itemCase71 = new Item("default", "1234", 200, 0);
        List<Item> allItems71 = List.of(itemCase71);
        assertTrue(SILab2.checkCart(allItems71, 500));

        // [U:F]
        assertFalse(SILab2.checkCart(allItems71, 0));




    }


}
