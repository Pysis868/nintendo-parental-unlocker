package me.nand.npu.core;

public class UnlockerException extends Exception {

	public UnlockerException(String message) {
		super(message);
	}

	public UnlockerException(String message, Exception e) {
		super(message, e);
	}
}
