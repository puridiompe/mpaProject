/**
 * 
 */
package com.puridiompe.mpa.movil.repository.file;

import java.io.IOException;

/**
 * @author Johnny
 *
 */
public interface FileRepository {

	public Integer saveBase64(String fileName, String base64toDecode);
	
	public String getBase64(String fileName);	
}
