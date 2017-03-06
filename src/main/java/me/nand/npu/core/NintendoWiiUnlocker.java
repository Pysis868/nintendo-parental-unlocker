package me.nand.npu.core;

import java.nio.charset.Charset;
import java.time.MonthDay;
import java.util.zip.CRC32;
import lombok.NonNull;
import org.apache.commons.lang.StringUtils;

class NintendoWiiUnlocker implements Unlocker {

	private final String MASTER_KEY_FORMAT = "%02d%02d%s";

	private String confirmNumber;

	private MonthDay monthDay;

	NintendoWiiUnlocker(@NonNull String confirmNumber, @NonNull MonthDay monthDay) throws UnlockerException {
		if (StringUtils.isNumeric(confirmNumber) && confirmNumber.trim().length() == 8) {
			this.confirmNumber = confirmNumber;
			this.monthDay = monthDay;
		} else {
			throw new UnlockerException("Invalid confirmation number");
		}
	}

	@Override
	public String getPin() {
		String masterKey = String.format(MASTER_KEY_FORMAT, monthDay.getMonthValue(), monthDay.getDayOfMonth(),
				confirmNumber.subSequence(4, 8));
		byte[] bytes = masterKey.getBytes(Charset.forName("US-ASCII"));
		CRC32 crc32 = new CRC32();
		crc32.update(bytes);
		long crc = crc32.getValue() ^ 0xffffffffL;
		return Long.toString(((crc ^ 0xaaaa) + 0x14c1) % 100000);
	}
}
