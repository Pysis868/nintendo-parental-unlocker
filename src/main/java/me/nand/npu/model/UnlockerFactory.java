package me.nand.npu.core;

import java.time.MonthDay;
import lombok.NonNull;
import org.apache.commons.lang.NotImplementedException;

public class UnlockerFactory {

	public static Unlocker createUnlocker(@NonNull Platform platform, @NonNull String number,
			@NonNull MonthDay systemDate) throws UnlockerException {
		Unlocker unlocker;
		switch (platform) {
			case NintendoDS:
				throw new NotImplementedException("Not implemented yet");
			case NintendoWii:
				unlocker = new NintendoWiiUnlocker(number, systemDate);
				break;
			case NintendoDSi:
				throw new NotImplementedException("Not implemented yet");
			case Nintendo3DS:
				throw new NotImplementedException("Not implemented yet");
			case NintendoWiiU:
				throw new NotImplementedException("Not implemented yet");
			case NintendoSwitch:
				throw new NotImplementedException("Not implemented yet");
			default:
				throw new UnlockerException("Unknown platform");

		}
		return unlocker;
	}
}
