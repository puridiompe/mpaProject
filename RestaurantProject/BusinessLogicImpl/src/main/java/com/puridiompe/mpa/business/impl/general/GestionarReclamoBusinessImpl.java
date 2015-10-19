package com.puridiompe.mpa.business.impl.general;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.dataaccess.ImagenDao;
import com.puridiompe.mpa.dataaccess.ReclamoDao;

@Service
public class GestionarReclamoBusinessImpl implements GestionarReclamoBusiness {

	@Autowired
	private ReclamoDao reclamoDao;
	
	@Autowired
	private ImagenDao imagenDao;
	
	@Override
	public void setReclamo(Integer dni, String descripcion, String vehiculo, List<String> imagenesBase64) {
		
		if(!imagenesBase64.isEmpty()){
			String filePath ="/home/puridiompe/";
			Integer arraySize = imagenesBase64.size();
			
			for(Integer pos = 0; pos < arraySize; pos++){
				
				String elementBase64 = imagenesBase64.get(pos);
				String fileType = elementBase64.substring(11, 14);
				String elementBase64toDecode = elementBase64.substring(22);
				byte[] data = Base64.getDecoder().decode(elementBase64toDecode);				
						
				synchronized (this)
				{
					Long name = new Date().getTime();
					String fileName = name.toString();
					
					filePath += fileName;				
					filePath += ".";
					filePath += fileType;		
					
					try (OutputStream stream = new FileOutputStream(filePath)) {
						stream.write(data);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					imagenDao.setImagen("REC", fileName, fileType, data.length);
				}
				filePath ="/home/puridiompe/";
			}
					
		}		
		reclamoDao.setReclamo(dni, descripcion, vehiculo);
	}

	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		return reclamoDao.getReclamosFrecuentes();
	}

}
