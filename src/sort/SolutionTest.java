package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void twoSum() {
        int[] ints = new Solution().twoSum(new int[]{3, 2, 4}, 6);
        Assertions.assertEquals(new int[]{1,2},ints);
    }
}