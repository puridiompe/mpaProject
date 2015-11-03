/**
 * 
 */
package com.puridiompe.mpa.movil.repository.file.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.puridiompe.mpa.movil.repository.file.FileRepository;

/**
 * @author Johnny
 *
 */
@Repository
public class FileRepositoryImpl implements FileRepository {
	
	@Autowired
	private Environment env;

	@Override
	public Integer saveBase64(String fileName, String base64toDecode) {
		String filePath = env.getProperty("file.store.image.path");
		
		byte[] data = Base64.getDecoder().decode(base64toDecode);

		try (OutputStream stream = new FileOutputStream(filePath + fileName)) {
			stream.write(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data.length;
	}
	
	@Override
	public String getBase64(String fileName){
		String filePath = env.getProperty("file.store.image.path");		
		String res = new String();
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		BufferedImage img;
		try {
			img = ImageIO.read(new File(filePath,fileName));
			int dotIndex = fileName.indexOf(".");
			String fileType = fileName.substring(dotIndex+1, fileName.length()); 
			ImageIO.write(img, fileType, baos);
			baos.flush();
			res = Base64.getEncoder().encodeToString(baos.toByteArray());
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int dotIndex = fileName.indexOf(".");
		String fileType = fileName.substring(dotIndex+1, fileName.length());
		
		res = "data:image/" + fileType + ";base64," + res;
		
		//String res ="data:image/png;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAEMuMjoyKkM6NjpLR0NPZKZsZFxcZMySmnmm8dT++u3U6eX//////////+Xp////////////////////////////2wBDAUdLS2RXZMRsbMT//+n/////////////////////////////////////////////////////////////////////wAARCABkADgDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwC1S0UtUSFGKWikAlIadTTTAb/EKKUdSaKQxwpaBS0CCiiigBKQ06mmgBvYmij+GimBCLg+lKLg+magzSikOxP9oP8AdpftH+zUFFAWJ/tA9DQsoc46Gq9JnBzQFiy7EJx1xRTdwZc0UagVxilpoHNO/GkMXIPSijFGKBhSUYpKAHI2047GimEUU7isLS0gpfwqRhS0lGKACg0YFJ0oAQ0UGimAtKKbmlzUjFoozSZ9qYC0lGaQmgBDRRmigAFLRRSAKUUUUwAim0UUAFFFFAH/2Q==";
				
		return res;
	}	

}
