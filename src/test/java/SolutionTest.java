package test.java;

import main.java.Constants;
import main.java.InvalidParamsException;
import main.java.Solution;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

/**
 * Тесты конечного алгоритма
 */
public class SolutionTest {
    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSolutionCorrectMain() {
        String field = "STWSWTPPTPTTPWPP";
        String species = Constants.human;

        int res = Solution.getResult(field, species);
        Assert.assertEquals(10, res);
    }

    @Test
    public void testSolutionWrongSpecies() {
        String field = "STWSWTPPTPTTPWPP";
        String species = "Pigeon123";

        thrown.expect(InvalidParamsException.class);
        int res = Solution.getResult(field, species);
    }

    @Test
    public void testSolutionCorrectSimple() {
        String field = "PPPPSSSPSSSPSSSP";
        int res = Solution.getResult(field, Constants.human);
        Assert.assertEquals(6, res);

        field = "PPPPPSSSPSSSPPPP";
        res = Solution.getResult(field, Constants.human);
        Assert.assertEquals(6, res);
    }

}
