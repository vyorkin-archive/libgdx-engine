package com.vyorkin.engine.exceptions;

public class GameEngineException extends RuntimeException {
	private static final long serialVersionUID = -1969912194914057600L;

	public GameEngineException(String message) {
		super(message);
	}

	public GameEngineException(Throwable t) {
		super(t);
	}

	public GameEngineException(String message, Throwable t) {
		super(message, t);
	}
}
