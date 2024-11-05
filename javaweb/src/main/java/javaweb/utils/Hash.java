package javaweb.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class Hash {
	//生鹽
		public static String getSalt() {
			SecureRandom secureRandom=new SecureRandom();
			byte[]salt=new byte[16];
			secureRandom.nextBytes(salt);
			return Base64.getEncoder().encodeToString(salt);
		}
		
		//生鹽雜湊
		public static String getHash(String password,String salt) {
			try {
				//加密算法 SHA256
				MessageDigest md=MessageDigest.getInstance("SHA-256");
				//加鹽巴
				md.update(salt.getBytes());
				//進行加密
				byte[]bytes=md.digest(password.getBytes());
				//將byte儲存
				return Base64.getEncoder().encodeToString(bytes);
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//生雜湊
			public static String getHash(String password) {
				try {
					//加密算法 SHA256
					MessageDigest md=MessageDigest.getInstance("SHA-256");
					//進行加密
					byte[]bytes=md.digest(password.getBytes());
					//將byte儲存
					return Base64.getEncoder().encodeToString(bytes);
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}
}
