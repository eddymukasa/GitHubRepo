package com.eddy.cribz.bookingSystem.core.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * sequence number generator.
 * 
 * @author Planet Dev002
 * 
 */
public final class SequenceGenerator {

	private static final AtomicLong sequence = new AtomicLong();

	/**
	 * default constructor made private to avoid instatiation.
	 */
	private SequenceGenerator() {
	}

	public static long next() {
		return sequence.incrementAndGet();
	}
}
