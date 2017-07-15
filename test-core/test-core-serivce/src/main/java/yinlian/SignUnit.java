package yinlian;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;


public class SignUnit {

	/**
	 * 请求报文签名(使用配置文件中配置的私钥证书或者对称密钥签名)<br>
	 * 功能：对请求报文进行签名,并计算赋值certid,signature字段并返回<br>
	 * 
	 * @param reqData
	 *            请求报文map<br>
	 * @param encoding
	 *            上送请求报文域encoding字段的值<br>
	 * @return 签名后的map对象<br>
	 */
	public static Map<String, String> createRequest(Map<String, String> reqData, String path,String key) {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		reqData = filterBlank(reqData);
		
		String stringSign = SignUnit.signature(reqData,path,key);
		
		reqData.put(UnionPayConstants.param_signature,stringSign);
		
		return reqData;
	}

	
	
	private static String signature(Map<String, String> data, String path,String key) {
		// 设置签名证书序列号
		data.put(UnionPayConstants.param_certId, getSignCertId(path,key));
		// 将Map信息转换成key1=value1&key2=value2的形式
		String stringData = coverMap2String(data);
		LogUtil.writeLog("待签名请求报文串:[" + stringData + "]");
		byte[] byteSign = null;
		String stringSign = null;
		try {
			// 通过SHA256进行摘要并转16进制
			byte[] signDigest = SecureUtil.sha256X16(stringData, UnionPayConstants.ENCODING);
			byteSign = SecureUtil
					.base64Encode(SecureUtil.signBySoft256(getSignCertPrivateKey(key), signDigest));
			stringSign = new String(byteSign);
			// 设置签名域值
			return stringSign;
		} catch (Exception e) {
			LogUtil.writeErrorLog("Sign Error", e);
			return null;
		}
	}


	/**
	 * 判断字符串是否为NULL或空
	 * 
	 * @param s
	 *            待判断的字符串数据
	 * @return 判断结果 true-是 false-否
	 */
	public static boolean isEmpty(String s) {
		return null == s || "".equals(s.trim());
	}

	/**
	 * 将Map中的数据转换成key1=value1&key2=value2的形式 不包含签名域signature
	 * 
	 * @param data
	 *            待拼接的Map数据
	 * @return 拼接好后的字符串
	 */
	public static String coverMap2String(Map<String, String> data) {
		TreeMap<String, String> tree = new TreeMap<String, String>();
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			if (UnionPayConstants.param_signature.equals(en.getKey().trim())) {
				continue;
			}
			tree.put(en.getKey(), en.getValue());
		}
		it = tree.entrySet().iterator();
		StringBuffer sf = new StringBuffer();
		while (it.hasNext()) {
			Entry<String, String> en = it.next();
			sf.append(en.getKey() +"=" + en.getValue() + "&");
		}
		return sf.substring(0, sf.length() - 1);
	}
	
	/**
	 * 过滤请求报文中的空字符串或者空字符串
	 * @param contentData
	 * @return
	 */
	public static Map<String, String> filterBlank(Map<String, String> contentData){
		LogUtil.writeLog("打印请求报文域 :");
		Map<String, String> submitFromData = new HashMap<String, String>();
		Set<String> keyset = contentData.keySet();
		
		for(String key:keyset){
			String value = contentData.get(key);
			if (StringUtils.isNotBlank(value)) {
				// 对value值进行去除前后空处理
				submitFromData.put(key, value.trim());
//				LogUtil.writeLog(key + "-->" + String.valueOf(value));
			}
		}
		return submitFromData;
	}
	
	
	/**
	 * 获取配置文件acp_sdk.properties中配置的签名私钥证书certId
	 * keyStore = getKeyInfo("D:/certs/acp_test_sign.pfx","000000", "PKCS12");
	 * @return 证书的物理编号
	 */
	/** 证书容器，存储对商户请求报文签名私钥证书. */
	static KeyStore keyStore = null;
	public static String getSignCertId(String path,String key) {
		try {
			keyStore = getKeyInfo(path+ "/898310173990682.pfx",key, UnionPayConstants.PKCS12);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Enumeration<String> aliasenum = keyStore.aliases();
			String keyAlias = null;
			if (aliasenum.hasMoreElements()) {
				keyAlias = aliasenum.nextElement();
			}
			X509Certificate cert = (X509Certificate) keyStore
					.getCertificate(keyAlias);
			return cert.getSerialNumber().toString();
		} catch (Exception e) {
			LogUtil.writeErrorLog("getSignCertId Error", e);
			return null;
		}
	}

	
	/**
	 * 将签名私钥证书文件读取为证书存储对象
	 * 
	 * @param pfxkeyfile
	 *            证书文件名
	 * @param keypwd
	 *            证书密码
	 * @param type
	 *            证书类型
	 * @return 证书对象
	 * @throws IOException 
	 */
	private static KeyStore getKeyInfo(String pfxkeyfile, String keypwd,
			String type) throws IOException {
		LogUtil.writeLog("加载签名证书==>" + pfxkeyfile);
		FileInputStream fis = null;
		try {
			KeyStore ks = KeyStore.getInstance(type, "BC");
			LogUtil.writeLog("Load RSA CertPath=[" + pfxkeyfile + "],Pwd=["+ keypwd + "],type=["+type+"]");
			fis = new FileInputStream(pfxkeyfile);
			char[] nPassword = null;
			nPassword = null == keypwd || "".equals(keypwd.trim()) ? null: keypwd.toCharArray();
			if (null != ks) {
				ks.load(fis, nPassword);
			}
			return ks;
		} catch (Exception e) {
			LogUtil.writeErrorLog("getKeyInfo Error", e);
			return null;
		} finally {
			if(null!=fis)
				fis.close();
		}
	}
	
	/**
	 * 通过keyStore 获取私钥签名证书PrivateKey对象
	 * @param key 
	 * 
	 * @return
	 */
	public static PrivateKey getSignCertPrivateKey(String key) {
		try {
			Enumeration<String> aliasenum = keyStore.aliases();
			String keyAlias = null;
			if (aliasenum.hasMoreElements()) {
				keyAlias = aliasenum.nextElement();
			}
			PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias,key.toCharArray());
			return privateKey;
		} catch (KeyStoreException e) {
			LogUtil.writeErrorLog("getSignCertPrivateKey Error", e);
			return null;
		} catch (UnrecoverableKeyException e) {
			LogUtil.writeErrorLog("getSignCertPrivateKey Error", e);
			return null;
		} catch (NoSuchAlgorithmException e) {
			LogUtil.writeErrorLog("getSignCertPrivateKey Error", e);
			return null;
		}
	}
}
