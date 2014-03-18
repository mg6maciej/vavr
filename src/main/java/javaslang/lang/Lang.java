package javaslang.lang;

import java.util.function.Supplier;

import javaslang.collection.Arrays;
import javaslang.util.Strings;

/**
 * General Java languange extensions.
 */
public final class Lang {

	private Lang() {
		throw new AssertionError(Lang.class.getName() + " cannot be instantiated.");
	}

	/**
	 * Calls {code print(supplier.get())}.
	 * 
	 * @param supplier An Object supplier
	 */
	public static void print(Supplier<Object> supplier) {
		print(supplier.get());
	}

	/**
	 * Calls {code println(supplier.get())}.
	 * 
	 * @param supplier An Object supplier
	 */
	public static void println(Supplier<Object> supplier) {
		println(supplier.get());
	}

	/**
	 * Shortcut for {@code System.out.print(javaslang.text.Strings.toString(o))}.
	 * 
	 * @param o an Object
	 */
	public static void print(Object o) {
		final String s = Strings.toString(o);
		System.out.print(s);
	}

	/**
	 * Shortcut for {@code System.out.println(javaslang.text.Strings.toString(o))}.
	 * 
	 * @param o an Object
	 */
	public static void println(Object o) {
		final String s = Strings.toString(o);
		System.out.println(s);
	}

	/**
	 * Shortcut for
	 * {@code System.out.print(String.format(format, Arrays.map(objects, Objects::toString)))}.
	 * 
	 * @param format A String format
	 * @param objects Zero or more String format arguments
	 * 
	 * @see String#format(String, Object...)
	 */
	public static void print(String format, Object... objects) {
		final Object[] args = Arrays.map(objects, Strings::toString);
		final String s = String.format(format, args);
		System.out.print(s);
	}

	/**
	 * Shortcut for {@code System.out.println(String.format(format, Arrays.map(objects,
	 * Objects::toString)))}.
	 * 
	 * @param format A String format
	 * @param objects Zero or more String format arguments
	 * 
	 * @see String#format(String, Object...)
	 */
	public static void println(String format, Object... objects) {
		final Object[] args = Arrays.map(objects, Strings::toString);
		final String s = String.format(format, args);
		System.out.println(s);
	}

	/**
	 * Runtime check which will throw an IllegalStateException containing the given message if the
	 * condition is false.
	 * 
	 * @param condition A boolean
	 * @param message A message An error message.
	 * @throws IllegalStateException If condition is false, contains the message.
	 */
	public static void require(boolean condition, String message) throws IllegalStateException {
		if (!condition) {
			throw new IllegalStateException(message);
		}
	}

	/**
	 * Runtime check which will throw an IllegalStateException containing the given message if the
	 * condition is false. The message is computed only if the condition is false.
	 * 
	 * @param condition A boolean
	 * @param messageSupplier An error message, computed lazily.
	 * @throws IllegalStateException If condition is false, contains the message.
	 */
	public static void require(boolean condition, Supplier<String> messageSupplier)
			throws IllegalStateException {
		if (!condition) {
			throw new IllegalStateException(messageSupplier.get());
		}
	}

}