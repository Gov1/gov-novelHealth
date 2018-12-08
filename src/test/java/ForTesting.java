import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class ForTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(8);
		String encoder1=encoder.encode("john");
			System.out.println(encoder1);

			//MessageDigest md=MessageDigest.getInstance("MD5");
			//md.update("john".getBytes());
			//byte[] encode=md.digest();
			//System.out.println(encode.toString());
			//System.out.println(Base64.getEncoder().encodeToString(encode));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Object getBytes() {
		// TODO Auto-generated method stub
		return null;
	}

}
