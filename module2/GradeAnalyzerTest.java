import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {

    @Test
    public void calculateAverage_returnsCorrectAverage_forTypicalScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 70));
        assertEquals(80.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    public void calculateAverage_returnsSingleScore_forOneElementList() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(95));
        assertEquals(95.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    public void calculateAverage_returnsZero_forEmptyList() {
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    public void calculateAverage_returnsCorrectAverage_whenAllScoresAreTheSame() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75, 75, 75, 75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    public void calculateAverage_handlesDecimalResult_correctly() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(100, 0));
        assertEquals(50.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    // Additional test 1: verify exact average with 10 scores
    @Test
    public void calculateAverage_returnsExactAverage_forTenScores() {
        ArrayList<Integer> scores = new ArrayList<>(
            Arrays.asList(55, 60, 65, 70, 75, 80, 85, 90, 95, 100)
        );
        // sum = 775, average = 77.5
        assertEquals(77.5, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    // Additional test 2: list with a perfect score and a zero
    @Test
    public void calculateAverage_handlesExtremeValues_correctly() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(0, 100, 50));
        assertEquals(50.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }
}
