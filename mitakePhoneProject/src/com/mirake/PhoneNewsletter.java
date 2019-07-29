package com.mirake;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PhoneNewsletter {

	public static void main(String[] args) throws ProtocolException {

		// reqUrl.append("http://smsapi.mitake.com.tw/api/mtk/SmSend?"); 單筆傳送簡訊方式
		/**
		 * http://smsapi.mitake.com.tw/api/mtk/SmSend?username=55779783&&password=536225ab&dstaddr=0908137867&smbody=1515&CharsetURL=UTF-8
		 */
//		try {
//			StringBuffer reqUrl = new StringBuffer();
////			reqUrl.append("http://smsapi.mitake.com.tw/b2c/mtk/SmSend?");
//			reqUrl.append("http://smsapi.mitake.com.tw/api/mtk/SmSend?");
//			reqUrl.append("username=55779783");
//			reqUrl.append("&password=536225ab");
//			reqUrl.append("&dstaddr=0908137867");
//			reqUrl.append("&smbody=" + URLEncoder.encode("this.istest ", "UTF-8"));
//			reqUrl.append("&CharsetURL=UTF-8");
//			URL url = new URL(reqUrl.toString());
//			HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("GET");
//			int code= urlConnection.getResponseCode();
//			String ex = urlConnection.getResponseMessage();
//			System.out.println("取得程式碼:"+code);
//			System.out.println("取得回傳訊息:"+ex);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		URL url;
		try {
			url = new URL("http://smsapi.mitake.com.tw/api/mtk/SmBulkSend?username=55779783&password=536225ab&Encoding_PostIn=UTF-8");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
			StringBuffer body = new StringBuffer();
			
			body.append("82555$$0985803583$$$$$$$$$$陳昱全阿屋阿屋窯樂窯樂").append("\r\n");
			body.append("98547$$0920323591$$$$$$$$$$陳昱全阿屋阿屋窯樂窯樂").append("\r\n");
			out.write(body.toString().getBytes("UTF-8"));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	// HTTP POST请求
	public static void sendPost() throws Exception {
		String USER_AGENT = "Mozilla/5.0";
		String url = "http://smsapi.mitake.com.tw/api/mtk/SmBulkSend";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// 添加请求头
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "username=55779783&password=536225ab&Encoding_PostIn=utf-8&objectID=154";

		// 发送Post请求
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		StringBuffer body = new StringBuffer();
		body.append(urlParameters);
		body.append("001$$0908137867$$20170101000000$$20170102000000$$$$$$簡訊SmBulkSend測試").append("\r\n");
		body.append("002$$0923551951$$20170101000000$$20170102000000$$$$$$簡訊SmBulkSend測試").append("\r\n");
//		wr.writeBytes(urlParameters);
		wr.write(body.toString().getBytes("UTF-8"));
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		String respMessage = con.getResponseMessage();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters:" + urlParameters);
		System.out.println("Response Code : " + responseCode);
		System.out.println("Response Message : " + respMessage);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// 打印结果
		System.out.println(response.toString());

	}
	
	/**
	 * 
	 * @param messageContents  需要傳送的訊息內容
	 * @param messageTransferNumber 傳送的訊息代號
	 * @return
	 */
	public static String sendSMSmessaging(String messageContents ,  String messageTransferNumber) {
		URL url;
		
		try {
			// DB 帳號密碼資料區域 
			String driver = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/user";
			String username = "test";
			String password = "test";
			// DB 帳號密碼資料區域 
			String sql = "select * from MITK_CUST_INFORMATION";//編寫要執行的sql語句，此處為從user表中查詢所有使用者的資訊
			
			
			
			url = new URL("http://smsapi.mitake.com.tw/api/mtk/SmBulkSend?username=55779783&password=536225ab&Encoding_PostIn=UTF-8");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
			StringBuffer body = new StringBuffer();	
			body.append("82555$$0985803583$$$$$$$$$$" + messageContents).append("\r\n");
			body.append("98547$$0920323591$$$$$$$$$$" + messageContents).append("\r\n");
			out.write(body.toString().getBytes("UTF-8"));
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			System.out.println(response.toString());
			
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

}
