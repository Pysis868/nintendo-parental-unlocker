package me.nand.npu.core;

import java.time.MonthDay;
import static me.nand.npu.core.Platform.NintendoWii;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WiiUnlockerTest {

	@Test
	public void getPin_validInput_ShouldBeEquals() throws UnlockerException {
		String confirmNumber = "61195115";
		MonthDay monthDay = MonthDay.of(2, 24);
		String pin = "88896";
		Unlocker unlocker = UnlockerFactory.createUnlocker(NintendoWii, confirmNumber, monthDay);
		assertEquals(pin, unlocker.getPin());
	}

	@Test(expected = NullPointerException.class)
	public void getPin_nullConfirmNumber_ThrowsNullPointerException() throws UnlockerException {
		MonthDay monthDay = MonthDay.of(2, 24);
		UnlockerFactory.createUnlocker(NintendoWii, null, monthDay);
	}

	@Test(expected = UnlockerException.class)
	public void getPin_emptyConfirmNumber_ThrowsUnlockerException() throws UnlockerException {
		MonthDay monthDay = MonthDay.of(2, 24);
		UnlockerFactory.createUnlocker(NintendoWii, "", monthDay);
	}

	@Test(expected = UnlockerException.class)
	public void getPin_shortConfirmNumber_ThrowsUnlockerException() throws UnlockerException {
		MonthDay monthDay = MonthDay.of(2, 24);
		UnlockerFactory.createUnlocker(NintendoWii, "1234567", monthDay);
	}

	@Test(expected = UnlockerException.class)
	public void getPin_LongConfirmNumber_ThrowsUnlockerException() throws UnlockerException {
		MonthDay monthDay = MonthDay.of(2, 24);
		UnlockerFactory.createUnlocker(NintendoWii, "123456789", monthDay);
	}

	@Test(expected = UnlockerException.class)
	public void getPin_invalidFormatConfirmNumber_ThrowsUnlockerException() throws UnlockerException {
		MonthDay monthDay = MonthDay.of(2, 24);
		UnlockerFactory.createUnlocker(NintendoWii, "1A2B3C4D", monthDay);
	}

	@Test(expected = NullPointerException.class)
	public void getPin_nullMothDay_ThrowsNullPointerException() throws UnlockerException {
		UnlockerFactory.createUnlocker(NintendoWii, "12345678", null);
	}
}
