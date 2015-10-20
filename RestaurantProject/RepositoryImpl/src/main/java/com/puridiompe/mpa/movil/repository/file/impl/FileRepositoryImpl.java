/**
 * 
 */
package com.puridiompe.mpa.movil.repository.file.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

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

}
