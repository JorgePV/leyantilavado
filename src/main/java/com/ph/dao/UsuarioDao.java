package com.ph.dao;

import com.eph.vo.EntityVO;
import com.eph.vo.commons.ResponseVO;
import com.ph.config.SunnelRestWSImpl;

public class UsuarioDao {
	String nombreUsuario;
    String paswdUsuario;
	
	public ResponseVO<EntityVO> existeUsuario()
    {
        System.out.println("Validando usuario ++++++");
        SunnelRestWSImpl sunnelRestWS = new SunnelRestWSImpl();
        System.out.println("Validando usuario 1  ++++++");
        sunnelRestWS.invokeLoginPerUser(getNombreUsuario(), getPaswdUsuario());
        System.out.println("Validando usuario 2 ++++++");
        ResponseVO<EntityVO> response = sunnelRestWS.getResponse();
        System.out.println("Respuesta Servicio  " +response);
        boolean existeUsuario = false;
        return response;
    }

	private String getPaswdUsuario() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}

	private String getNombreUsuario() {
		// TODO Auto-generated method stub
		return paswdUsuario;
	}

}
