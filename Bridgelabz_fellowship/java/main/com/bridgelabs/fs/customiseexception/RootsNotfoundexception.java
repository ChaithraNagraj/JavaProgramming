package com.bridgelabs.fs.customiseexception;

public class RootsNotfoundexception extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1231640301751334631L;

	public RootsNotfoundexception() {
		super("roots is lees than zero, this equation doesnnot have roots");
	
}
}