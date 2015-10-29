/**
 * 
 */
package com.puridiompe.mpa.rest.security.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Johnny
 *
 */
public class Network {

	private static final Logger logger = LoggerFactory.getLogger(Network.class);

	private static String localIp = "";

	private static Set<String> localAddresses = new HashSet<String>();

	public static String getClientImei(String imei, HttpServletRequest request) {

		if (imei == null || imei.length() <= 0) {
			imei = getClientRemoteIp(request);
		}

		if (localAddresses.size() <= 0) {
			synchronized (Network.class) {
				if (localAddresses.size() <= 0) {
					setServerIp();
				}
			}
		}

		if (localAddresses.contains(imei)) {
			logger.info("Login in local connection");
			imei = localIp;
			//Random rnd = new Random();
			//imei += "."+rnd.nextInt(900)+100;
		}

		return imei;
	}

	/**
	 * Gets remote client ip address from request object
	 * 
	 * @param request
	 * @return
	 */
	private static String getClientRemoteIp(HttpServletRequest request) {
		String remoteAddress = request.getHeader("X-Forwarded-For");
		String clientIpAddress = null;

		if (remoteAddress != null && remoteAddress.length() > 0) {
			logger.debug("X-Forwarded-For " + remoteAddress);

			clientIpAddress = remoteAddress.split(",")[0];

		} else {
			remoteAddress = request.getHeader("X-FORWARDED-FOR");

			if (remoteAddress != null && remoteAddress.length() > 0) {
				logger.debug("X-FORWARDED-FOR " + remoteAddress);

				clientIpAddress = remoteAddress.split(",")[0];
			}
		}

		if (clientIpAddress == null) {

			clientIpAddress = request.getRemoteAddr();

			logger.debug("RemoteAddress " + clientIpAddress);
		}

		return clientIpAddress;
	}

	/**
	 * Gets local server Ip
	 * 
	 * @return
	 */
	private static void setServerIp() {
		Enumeration<NetworkInterface> interfaces = null;

		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException exception) {
			logger.error("Error getting Network Interfaces", exception);
		}

		if (interfaces != null) {

			while (interfaces.hasMoreElements()) {
				NetworkInterface current = interfaces.nextElement();

				logger.debug("Curent NetworkInterface " + current);

				try {
					if (!current.isUp() || current.isLoopback()
							|| current.isVirtual()) {
						continue;
					}
				} catch (SocketException exception) {
					logger.error("Error when Network Interface is evaluated",
							exception);
				}

				Enumeration<InetAddress> addresses = current.getInetAddresses();

				while (addresses.hasMoreElements()) {
					InetAddress current_addr = addresses.nextElement();

					logger.debug("FFCurrent HostAddress "
							+ current_addr.getHostAddress());

					if (current_addr.isLoopbackAddress()) {
						continue;
					}

					logger.debug("Current HostAddress "
							+ current_addr.getHostAddress());

					localAddresses.add(current_addr.getHostAddress());

					if (current_addr instanceof Inet4Address) {

						logger.debug("Current HostAddress is Inet4Address");

						localIp = current_addr.getHostAddress();

						// break;
					} else if (current_addr instanceof Inet6Address) {

						logger.debug("Current HostAddress is Inet6Address");
					} else {
						logger.debug("Current HostAddress is other type");
					}
				}
			}
		}
	}
}
