package com.puridiompe.mpa.business.impl.general;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puridiompe.mpa.business.general.GestionarReclamoBusiness;
import com.puridiompe.mpa.business.general.dto.ReclamoDto;
import com.puridiompe.mpa.dataaccess.ReclamoDao;

@Service
public class GestionarReclamoBusinessImpl implements GestionarReclamoBusiness {

	@Autowired
	private ReclamoDao reclamoDao;
	
	@Override
	public void setReclamo(Integer dni, String descripcion, String vehiculo, String imagenBase64) {
		
		byte[] data = Base64.getDecoder().decode(imagenBase64);
		try (OutputStream stream = new FileOutputStream("/home/puridiompe/testImg.png")) {
		    stream.write(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reclamoDao.setReclamo(dni, descripcion, vehiculo);
	}

	@Override
	public List<ReclamoDto> getReclamosFrecuentes() {
		return reclamoDao.getReclamosFrecuentes();
	}

}
