package me.nand.npu.core;

public class UnlockerException extends Exception {

  private static final long serialVersionUID = 5469241275603512469L;

  public UnlockerException(String message) {
		super(message);
	}

	public UnlockerException(String message, Exception e) {
		super(message, e);
	}
}
