/**
 * 
 */
package com.puridiompe.mpa.rest.security.handler;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.puridiompe.mpa.rest.security.util.Encryption;


/**
 * @author Johnny
 *
 */
@Component
public class HeaderAuthenticationHandler {

    private Encryption encryptionUtil = new Encryption();

    private static final String HEADER_NAME = "X-Auth-Token";

    private Period sessionMaxAge;

    private String seed;

    @Autowired
    private Environment environment;

    @PostConstruct
    private void init() {
        String encryptionEnabled = environment.getProperty("auth.encryption.enabled");
        if (StringUtils.isNotBlank(encryptionEnabled) && Boolean.parseBoolean(encryptionEnabled)) {
            encryptionUtil.encryptionEnabled(true);
            seed = environment.getRequiredProperty("auth.encryption.seed");
        }
        sessionMaxAge = getSessionMaxAge();
    }

    public String getUserName(HttpServletRequest request) {
        String header = request.getHeader(HEADER_NAME);
        return StringUtils.isNotBlank(header) ? extractUserName(header) : null;
    }
    
    public String getImei(HttpServletRequest request) {
        String header = request.getHeader(HEADER_NAME);
        return StringUtils.isNotBlank(header) ? extractImei(header) : null;
    }

    private String extractUserName(String value) {

        try {
            String decryptedValue = encryptionUtil.decrypt(value, seed);
            String[] split = decryptedValue.split("\\|");
            String username = split[0];
            String imei = split[1]; 
            DateTime timestamp =  new DateTime(Long.parseLong(split[2]));
            if (timestamp.isAfter(DateTime.now().minus(sessionMaxAge))) {
                return username;
            }
        } catch (IOException | GeneralSecurityException e) {
//            Logger.debug(this, "Unable to decrypt header" + e);
        }
        return null;
    }
    
    private String extractImei(String value) {

        try {
            String decryptedValue = encryptionUtil.decrypt(value, seed);
            String[] split = decryptedValue.split("\\|");
            String username = split[0];
            String imei = split[1]; 
            DateTime timestamp =  new DateTime(Long.parseLong(split[2]));
            if (timestamp.isAfter(DateTime.now().minus(sessionMaxAge))) {
                return imei;
            }
        } catch (IOException | GeneralSecurityException e) {
//            Logger.debug(this, "Unable to decrypt header" + e);
        }
        return null;
    }

    public void resetHeader(HttpServletResponse response) {
    	 response.setHeader(HEADER_NAME, "");
    }
    public void addHeader(HttpServletResponse response, String userName, String imei) {
        try {
            String encryptedValue = createAuthToken(userName, imei);
            response.setHeader(HEADER_NAME, encryptedValue);
        } catch (IOException | GeneralSecurityException e) {
//            Logger.error(this, "Unable to encrypt header" + e);
        }
    }

    public String createAuthToken(String userName, String imei) throws IOException, GeneralSecurityException {
        String value = userName + "|" + imei + "|" +System.currentTimeMillis();
        return encryptionUtil.encrypt(value, seed);
    }

    private Period getSessionMaxAge() {
        String maxAge = environment.getRequiredProperty("auth.session.maxAge");
        PeriodFormatter format = new PeriodFormatterBuilder()
                .appendDays()
                .appendSuffix("d", "d")
                .printZeroRarelyFirst()
                .appendHours()
                .appendSuffix("h", "h")
                .printZeroRarelyFirst()
                .appendMinutes()
                .appendSuffix("m", "m")
                .toFormatter();
        Period sessionMaxAge = format.parsePeriod(maxAge);
//        if (Logger.isDebugEnabled()) {
//        	Logger.debug(this, "Session maxAge is: "+
//                    formatIfNotZero(sessionMaxAge.getDays(), "days", "day") +
//                    formatIfNotZero(sessionMaxAge.getHours(), "hours", "hour") +
//                    formatIfNotZero(sessionMaxAge.getMinutes(), "minutes", "minute")
//            );
//        }
        return sessionMaxAge;
    }

    private static String formatIfNotZero(int value, String plural, String singleton) {
        if (value > 0) {
            if (value > 1) {
                return "" + value + " " + plural;
            }
            return "" + value + " " + singleton;
        }
        return "";
    }

}
