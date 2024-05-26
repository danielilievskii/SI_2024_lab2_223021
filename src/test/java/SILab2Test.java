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
        // S - NODE TEST CASES - 6
        // [S:FXX]
        Item itemCase61 = new Item("default", "1234", 250, 0);
        List<Item> allItems61 = List.of(itemCase61);
        assertTrue(SILab2.checkCart(allItems61, 500));

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
    }


}
