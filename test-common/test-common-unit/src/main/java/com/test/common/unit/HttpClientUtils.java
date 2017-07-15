package com.test.common.unit;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public class HttpClientUtils<T> {

	protected static HttpClient httpClient = HttpClientFactory.createHttpClient(100, 10);

	private static Map<String, HttpClient> httpClient_mchKeyStore = new HashMap<String, HttpClient>();

	public static void init(int maxTotal, int maxPerRoute) {
		httpClient = HttpClientFactory.createHttpClient(maxTotal, maxPerRoute);
	}

	/**
	 * 初始化 MCH HttpClient KeyStore
	 * 
	 * @param mch_id
	 * @param keyStoreFilePath
	 */
	public static void initMchKeyStore(String mch_id, String keyStoreFilePath) {
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(keyStoreFilePath));
			keyStore.load(instream, mch_id.toCharArray());
			instream.close();
			HttpClient httpClient = HttpClientFactory.createKeyMaterialHttpClient(keyStore, mch_id,
					new String[] { "TLSv1" });
			httpClient_mchKeyStore.put(mch_id, httpClient);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static HttpResponse execute(HttpUriRequest request) {
		try {
			return httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T execute(HttpUriRequest request,Class<T> clazz) {
		
		String result = "";
	    BufferedReader in = null;
	    try {
	        String urlNameString = request.getURI() + "?" + request.getParams();
	        URL realUrl = new URL(urlNameString);
	        // 打开和URL之间的连接
	        URLConnection connection = realUrl.openConnection();
	        // 设置通用的请求属性
	        connection.setRequestProperty("accept", "*/*");
	        connection.setRequestProperty("connection", "Keep-Alive");
	        connection.setRequestProperty("user-agent",
	                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        // 建立实际的连接
	        connection.connect();
	        // 定义 BufferedReader输入流来读取URL的响应
	        in = new BufferedReader(new InputStreamReader(
	                connection.getInputStream()));
	        String line;
	        while ((line = in.readLine()) != null) {
	            result += line;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // 使用finally块来关闭输入流
	    finally {
	        try {
	            if (in != null) {
	                in.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return null;
	}
    

	
	
	
	public static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) {
		try {
			return httpClient.execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 数据返回自动JSON对象解析
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeJsonResult(HttpUriRequest request, Class<T> clazz) {
		return execute(request, JsonResponseHandler.createResponseHandler(clazz));
	}

	/**
	 * 数据返回自动XML对象解析
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeXmlResult(HttpUriRequest request, Class<T> clazz) {
		return execute(request, XmlResponseHandler.createResponseHandler(clazz));
	}

	/**
	 * MCH keyStore 请求 数据返回自动XML对象解析
	 * 
	 * @param mch_id
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T keyStoreExecuteXmlResult(String mch_id, HttpUriRequest request, byte[] keyStoreData,
			Class<T> clazz) {
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			InputStream instream = new ByteArrayInputStream(keyStoreData);
			keyStore.load(instream, mch_id.toCharArray());
			instream.close();
			HttpClient httpClient = HttpClientFactory.createKeyMaterialHttpClient(keyStore, mch_id,
					new String[] { "TLSv1" });
			return httpClient.execute(request, XmlResponseHandler.createResponseHandler(clazz));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return null;
	}
}