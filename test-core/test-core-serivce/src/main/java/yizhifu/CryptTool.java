package yizhifu;

import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * CryptTool 闁跨喐鏋婚幏鐤棖闁跨喐鏋婚幏铚傜娴滄盯鏁撻弬銈嗗闁跨喐婢冮惂鍛婂闁跨喓顏崙銈嗗闁跨喐鏋婚幏锟�闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�3DES, MD5 闁跨喐鏋婚幏锟�
 * 
 * @author hxq
 * @version 1.0 2006-01-10
 */
public class CryptTool {

	public CryptTool() {
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	/**
	 * 閺夌儐鍓氬畷鑼拷濡ゅ嫬螡闁轰焦澹嗙划宥嗙▔閿燂拷閺夆晜绋戦崺妤冿拷濡炴崘顪�
	 *
	 * @param b
	 *            閻庢稒顨犳俊顓㈠极閹殿喚鐭�
	 * @return 16閺夆晜绋戦崺妤冿拷濡炴崘顪�
	 */

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString().toUpperCase();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 闁汇垻鍠愰崹锟紻ES閻庨潧妫濋幐锟�
	 *
	 * @param key_byte
	 *            seed key
	 * @throws Exception
	 * @return javax.crypto.SecretKey Generated DES key
	 */
	public static SecretKey genDESKey(byte[] key_byte)
			throws Exception {

		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	public static SecretKey genDESKey() throws Exception {
		String keyStr = "$1#2@f3&4~6%7!a+*cd(e-h)";// 濞达綀娉曢弫銈夊炊閸濆嫮鏆発ey
		// System.out.println("DES 闁告梻濮撮惁鎴炴媴鐠恒劍鏆忛柣銊ュ濞存劗锟藉鐞珁闁挎稑顔僥yStr 闁挎稒绻愮槐锟� + keyStr);
		byte key_byte[] = keyStr.getBytes();// 3DES 24 bytes key
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	public static SecretKey genDESKey(String key) throws Exception {
		String keyStr = key;// 濞达綀娉曢弫銈夊炊閸濆嫮鏆発ey
		// System.out.println("DES 闁告梻濮撮惁鎴炴媴鐠恒劍鏆忛柣銊ュ濞存劗锟藉鐞珁闁挎稑顔僥yStr 闁挎稒绻愮槐锟� + keyStr);
		byte key_byte[] = keyStr.getBytes();// 3DES 24 bytes key
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}


	/**
	 * 閻忓繐妫滈妴鍐矆閿燂拷閺夆晜绋戦崺妤呭磹閼测晜鐣遍悗娑欘殶椤戜焦绋夐懠鑸电ギ闁硅鏋嶇拹鐒峺te闁轰焦澹嗙划宥夋晬閿熶粙宕�鐬産lic static String byteArrayToHexString(byte[] b)
	 * 濞存粍甯婄拹鐔煎矗椤栫儑鎷烽柣銊ュ濞村棝骞戦姀锝囩畺缂佸鎷�	 *
	 * @param strIn
	 *            闂傚浄鎷烽—鍛姜椤掍礁搴婇柣銊ュ閻⊙呯箔閿旇儻顪�
	 * @return 閺夌儐鍓氬畷鏌ュ触鎼达絾鐣眀yte闁轰焦澹嗙划锟�	 * @throws Exception
	 *             闁哄牜鍓氶弻鐔封枖閺囨氨鐟濆璺哄閹﹥绂掔拋宕囩Э鐎殿喖鍊搁悥鍫曟晬鐏炴儳顣查柡鍫濐樆缁辨挾鏁粙鍨伎闂侇喓鍔嶆慨蹇涘礄閿燂拷	 * @author LiGuoQing
	 */
	public static byte[] hexString2ByteArray(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 濞戞挶鍊撻柌婊咃拷濡ゅ喚鍎婇悶娑栧妿閵囨碍绋夐敓浠嬪殝閻庢稒顨犳俊顓㈡晬鐏炴儳顣插ù鐘劚閻⊙囨嚍閸屾稒娈剁紓浣稿閺嗚鲸鎯旈敂鑺バ﹂悗娑欘殶椤戜焦绋夐弻銉︽瘣閹艰揪绠撳▍搴㈢閿燂拷
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 3DES 閻熸瑱绲介惁锟絙yte[]).
	 *
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desDecrypt(SecretKey key, byte[] crypt)
			throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(crypt);
	}

	/**
	 * 3DES 閻熸瑱绲介惁锟絊tring).
	 *
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desDecrypt(SecretKey key, String crypt)
			throws Exception {
		return byteArrayToHexString(desDecrypt(key, crypt.getBytes("UTF-8")));
	}

	/**
	 * 3DES闁告梻濮撮惁锟絙yte[]).
	 *
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static byte[] desEncrypt(SecretKey key, byte[] src)
			throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(src);
	}

	/**
	 * 3DES闁告梻濮撮惁锟絊tring).
	 *
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	public static String desEncrypt(SecretKey key, String src)
			throws Exception {
		return byteArrayToHexString(desEncrypt(key, src.getBytes("UTF-8")));
	}

	/**
	 * MD5 闁硅姤顭堥—鍛媼閿涘嫮鏆�byte[]).
	 *
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[] 16 bit digest
	 */
	public static byte[] md5Digest(byte[] src) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // MD5 is 16 bit message digest

		return alg.digest(src);
	}

	/**
	 * MD5 闁硅姤顭堥—鍛媼閿涘嫮鏆�String).
	 *
	 * @param src
	 *            String
	 * @throws Exception
	 * @return String
	 */
	public static String md5Digest(String src) throws Exception {
		return byteArrayToHexString(md5Digest(src.getBytes()));
	}

    /**
     * MD5 閻熸瑱绲介惁锟�     *
     * @param src
     *            String
     * @throws Exception
     * @return String
     */
    public static String md5Enc(String src) throws Exception {
        return byteArrayToHexString(md5Digest(src.getBytes()));
    }

	/**
	 * BASE64 缂傚倹鐗滈悥锟�
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Encode(String src) {
        Base64 encoder = new Base64();

		return encoder.encodeToString(src.getBytes());
	}

	/**
	 * BASE64 缂傚倹鐗滈悥锟絙yte[]).
	 *
	 * @param src
	 *            byte[] inputed string
	 * @return String returned string
	 */
	public static String base64Encode(byte[] src) {
        Base64 encoder = new Base64();

		return encoder.encodeToString(src);
	}

	/**
	 * BASE64 閻熸瑱绲块悥锟�
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static String base64Decode(String src) {
        Base64 decoder = new Base64();

		try {
			return byteArrayToHexString(decoder.decode(src));
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * BASE64 閻熸瑱绲块悥锟絫o byte[]).
	 *
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	public static byte[] base64DecodeToBytes(String src) {
		Base64 decoder = new Base64();
		try {
			return decoder.decode(src);
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 閻庨潧婀辩划鎵拷濮橆剛鎽熺紒妤嬬畳缁绘鎮伴敓绲孯L 缂傚倹鐗滈悥锟�
	 *
	 * @param src
	 *            String
	 * @return String
	 */
	public static String urlEncode(String src) {
		try {
			src = java.net.URLEncoder.encode(src, "UTF-8");

			return src;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return src;
	}

	/**
	 * 閻庨潧婀辩划鎵拷濮橆剛鎽熺紒妤嬬畳缁绘鎮伴敓绲孯L 閻熸瑱绲块悥锟�	 *
	 * @param value
	 *            閻熸瑱绲块悥婊堝礈瀹ュ洦鐣遍悗娑欘殶椤戜焦绋夐敓锟� * @return 閻熸瑱绲块悥婊堝触鎼达絾鐣遍悗娑欘殶椤戜焦绋夐敓锟� */
	public static String urlDecode(String value) {
		try {
			return java.net.URLDecoder.decode(value, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return value;
	}

    /**
     *  闁稿骏鎷稤ES闁告梻濮撮惁鎴︽晬鐏炶棄鏅檅ase64缂傚倹鐗滈悥锟�     * @param key  閻庨潧妫濋幐锟�     * @param str 闂傚浄鎷烽—鍛村礉閻樿尙妲曢柣銊ュ閻⊙呯箔閿旇儻顪�
     */
    public static String des3Base64Enc(SecretKey key,String str)throws Exception{
        if(key==null)
            key = genDESKey();
        byte[] enc = desEncrypt(key,str.getBytes());
        return base64Encode(enc);
    }

    /**
     *  闁稿繐娼宎se64閻熸瑱绲块悥锟介柛鎰舵嫹DES閻熸瑱绲介惁鎴︽晬閿燂拷     * @param key  閻庨潧妫濋幐锟�     * @param str 闂傚浄鎷烽—鍛村礉閻樿尙妲曢柣銊ュ閻⊙呯箔閿旇儻顪�
     */
    public static String des3Base64Dec(SecretKey key,String str)throws Exception{
        if(key==null)
            key = genDESKey();
        byte[] decbase64 = base64DecodeToBytes(str);
        byte[] dec = desDecrypt(key, decbase64);
        return new String(dec,"UTF-8");
    }
	
    
 // 闁告瑦鐗曠欢閬嶆偝閺夋寧韬柣銊ュ濡晠寮甸悤鍌滅闁哄秶鍘х槐顡縴yymmddhhmmss
 	public static String getCurrentDate() {
 		Calendar cal = Calendar.getInstance();
 		int year = cal.get(cal.YEAR);
 		int month = cal.get(cal.MONTH) + 1;
 		int day = cal.get(cal.DAY_OF_MONTH);
 		int hour = cal.get(cal.HOUR_OF_DAY);
 		int minute = cal.get(cal.MINUTE);
 		int second = cal.get(cal.SECOND);
 		String cDate = Integer.toString(year);
 		if (month < 10) {
 			cDate = cDate + "0" + Integer.toString(month);
 		} else {
 			cDate = cDate + Integer.toString(month);
 		}
 		if (day < 10) {
 			cDate = cDate + "0" + Integer.toString(day);
 		} else {
 			cDate = cDate + Integer.toString(day);
 		}
 		if (hour < 10) {
 			cDate = cDate + "0" + Integer.toString(hour);
 		} else {
 			cDate = cDate + Integer.toString(hour);
 		}
 		if (minute < 10) {
 			cDate = cDate + "0" + Integer.toString(minute);
 		} else {
 			cDate = cDate + Integer.toString(minute);
 		}
 		if (second < 10) {
 			cDate = cDate + "0" + Integer.toString(second);
 		} else {
 			cDate = cDate + Integer.toString(second);
 		}
 		return cDate.trim();
 	}
 	
 	// 闁告瑦鐗曠欢杈亹閹惧啿顤呴柡鍐﹀劜濠�拷闁哄秶鍘х槐顡縴yymmdd
 	public static String getTodayDate2() {
 		// 闁告帗绻傞‖濠囧礌閺嶃劍顦抽梻鍌︽嫹
 		Calendar RightNow = Calendar.getInstance();
 		return changeDatetoString2(RightNow);
 	}

 	// 閻忓繐妫欏Λ鈺呭嫉閻旂粯绁柟骞垮灪閸ㄦ氨锟藉Δ鍐惧剨濞戞搫鎷烽柡宥囧帶缁鳖摽yyymmdd
 	public static String changeDatetoString2(Calendar cDate) {
 		int Year;
 		int Month;
 		int Day;
 		String sDate = "";

 		// 闁告帗绻傞‖濠囧礌閺嶃劍顦抽梻鍌︽嫹
 		Year = cDate.get(Calendar.YEAR);
 		Month = cDate.get(Calendar.MONTH) + 1;
 		Day = cDate.get(Calendar.DAY_OF_MONTH);

 		sDate = Integer.toString(Year);
 		if (Month >= 10) {
 			sDate = sDate + Integer.toString(Month);
 		} else {
 			sDate = sDate + "0" + Integer.toString(Month);
 		}
 		if (Day >= 10) {
 			sDate = sDate + Integer.toString(Day);
 		} else {
 			sDate = sDate + "0" +
 		
 					Integer.toString(Day);
 		}
 		return sDate;
 	}
 		
 	
 	public static void main(String[] args) {
        try {
            
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
