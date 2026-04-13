package all.util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {
	private PasswordUtil() {}
	public static String hash(String password)
	{
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	public static boolean verify(String rawpassword,String storedHash)
	{
		return BCrypt.checkpw(rawpassword, storedHash);
	}
	
}
