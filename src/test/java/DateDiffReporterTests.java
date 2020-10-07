import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.exception.InvalidUserInputException;
import com.australiapost.datediffreporter.processor.CustomDateProcessor;
import com.australiapost.datediffreporter.processor.DateDiffReporter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class DateDiffReporterTests {

    CustomDateProcessor customDateProcessor = null;
    DateDiffReporter dateDiffReporterTester = null;

    @Before
    public void preTestCondition() {
        customDateProcessor = new CustomDateProcessor();
    }

    @Test(expected = InvalidUserInputException.class)
    public void testInvalidUserInput() throws InvalidDateException, InvalidUserInputException {
        String userDatePairInput = "30 06 1982 01 02 2021";
        dateDiffReporterTester = new DateDiffReporter(userDatePairInput, customDateProcessor);
        assertEquals(dateDiffReporterTester.calculateDiffInDays(),
                "Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'");

        userDatePairInput = "30 06 1982, 01 02 2021";
        dateDiffReporterTester = new DateDiffReporter(userDatePairInput, customDateProcessor);
        assertNotEquals(dateDiffReporterTester.calculateDiffInDays(),
                "Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'");

    }

    @Test(expected = InvalidDateException.class)
    public void testInvalidDate() throws InvalidDateException, InvalidUserInputException {
        String userDatePairInput = "30 06 1982, 01 02 2021";
        dateDiffReporterTester = new DateDiffReporter(userDatePairInput, customDateProcessor);
        assertEquals(dateDiffReporterTester.calculateDiffInDays(),
                "Please enter a valid date. Only years 1900-2020 are supported.");
    }

    @Test
    public void testSplitDates() {
        String datePair = "30 06 1982, 06 10 2020";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        String[] expectedOutput = {"30 06 1982", "06 10 2020"};
        assertArrayEquals(expectedOutput, customDateProcessor.splitDates(datePair));

        expectedOutput = new String[]{"30 06 1982", "06 10 2020"};
        assertThat(expectedOutput, not(equalTo(new String[]{"30 06 1982"})));
    }

    @Test
    public void testInvalidDates() throws InvalidDateException {
        String datePair = "30 06 1982, 01 02 2021";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        String[] datesArray = customDateProcessor.splitDates(datePair);
        assertFalse(customDateProcessor.isValidDates(datesArray));
    }

    @Test
    public void testCalculateDifferenceInDays() throws InvalidUserInputException, InvalidDateException {
        String datePair = "30 06 1982, 30 05 1987";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        String expectedOutPut = "30 06 1982, 30 05 1987, 1795";
        assertEquals(expectedOutPut, dateDiffReporterTester.calculateDiffInDays());

        datePair = "30 06 1982, 01 01 1912";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        expectedOutPut = "01 01 1912, 30 06 1982, -25748";
        assertEquals(expectedOutPut, dateDiffReporterTester.calculateDiffInDays());

        datePair = "01 01 1900, 31 12 2020";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        expectedOutPut = "01 01 1900, 31 12 2020, 44194";
        assertEquals(expectedOutPut, dateDiffReporterTester.calculateDiffInDays());

    }

    @Test
    public void testDatesInOrder() {
        String datePair = "30 06 1982, 30 05 1987";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        String[] datesArray = customDateProcessor.splitDates(datePair);
        String expectedDatesOrder = "30 06 1982, 30 05 1987";
        assertEquals(expectedDatesOrder, customDateProcessor.getDatesInOrder(datesArray[0], datesArray[1]));

        datePair = "30 06 1982, 01 01 1912";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        datesArray = customDateProcessor.splitDates(datePair);
        expectedDatesOrder = "01 01 1912, 30 06 1982";
        assertEquals(expectedDatesOrder, customDateProcessor.getDatesInOrder(datesArray[0], datesArray[1]));
    }

    @Test
    public void testCalculateDiffInDays() {
        String datePair = "30 06 1982, 30 05 1987";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        String[] datesArray = customDateProcessor.splitDates(datePair);
        assertEquals(1795, customDateProcessor.calculateDifferenceInDays(datesArray[0], datesArray[1]));

        datePair = "30 06 1982, 30 06 1982";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        datesArray = customDateProcessor.splitDates(datePair);
        assertEquals(0, customDateProcessor.calculateDifferenceInDays(datesArray[0], datesArray[1]));

        datePair = "01 01 1900, 31 12 2020";
        dateDiffReporterTester = new DateDiffReporter(datePair, customDateProcessor);
        datesArray = customDateProcessor.splitDates(datePair);
        assertEquals(44194, customDateProcessor.calculateDifferenceInDays(datesArray[0], datesArray[1]));
    }

}
