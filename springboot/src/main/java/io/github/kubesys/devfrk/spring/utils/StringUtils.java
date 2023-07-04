/**
 * Copyright (2023, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubesys.devfrk.spring.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author wuheng@iscas.ac.cn
 * @since 0.1.0
 * @date 2023/05/16
 * 
 */

public class StringUtils {

	
	private StringUtils() {
	}

	public static String getField(String method) {
		String name = method.startsWith("get") ? method.substring(3) : method.substring(2);
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}
	
	public static String getMethod(String field, boolean is) {
		String prefix = is ? "is" : "get";
		return prefix + field.substring(0, 1)
				.toUpperCase() + field.substring(1);
	}
	
	public static String getRandomString(int len) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString().toLowerCase();
	}
	
	public static boolean isBase64(String str) {
        String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        return Pattern.matches(base64Pattern, str);
    }
}
