package com.ph.config;


import com.eph.commons.LibraryUtil;
import com.eph.services.GenericResponse;
import com.eph.services.LoginService;
import com.eph.services.impl.GenericResponseImpl;
import com.eph.services.impl.LoginServiceImpl;
import com.eph.vo.AccountData;
import com.eph.vo.EntityVO;
import com.eph.vo.commons.HeaderVO;
import com.eph.vo.commons.RequestVO;
import com.eph.vo.commons.ResponseVO;
import com.eph.vo.request.SearchAccountRequest;

import lombok.extern.log4j.Log4j;


import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import java.util.List;
//import java.util.ResourceBundle;

@Log4j
public class SunnelRestWSImpl {
	
	private String uri;
    private String user;
    private String password;
    private String rToken;
    private String entity;
    private String uriSearchAccountWs;
    private ResponseVO<EntityVO> response;
    Logger log = Logger.getRootLogger();

    public void invokeLoginPerUser(String perUser, String pwd) {
    	
    	//Logger log = Logger.getRootLogger();
    	//System.out.println("Exception invokeLoginPerUser");
    	//pwd = "password";
    	//perUser = "JPEREZV";
        try {
            LoginService loginService = new LoginServiceImpl();
            properties();
            response = loginService.getToken(uri, perUser, pwd);
            //System.out.println("Login Per User " + perUser+ " pwd " + pwd + " URL " +uri);
            //System.out.println(response.getHeader().getxAuthToken());
            log.info(response.getHeader().getxAuthToken());
            rToken = response.getHeader().getxAuthToken();
            //System.out.println("rToken   --  " + rToken);
        } catch (Exception e) {
            log.info(e);
        	//System.out.println("Exception XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        	//System.out.println(e);
        	//System.out.println("tocken ++++++++++ "+rToken);
        	
        }
    }
	
    public AccountData searchAccount(String idCard) {

        properties();
        invokeLogin();

        //log.info("SEARCHACCOUNTS  idCard= " + idCard);
        AccountData accountData = null;

        try {
            GenericResponse genericResponse = new GenericResponseImpl();
            String url = uriSearchAccountWs;

            RequestVO<SearchAccountRequest> request = new RequestVO<>();
            SearchAccountRequest filter = new SearchAccountRequest();
            filter.setCardId(idCard);
            request.setData(filter);

            HeaderVO headerVO = new HeaderVO();
            headerVO.setxAuthToken(rToken);
            headerVO.setEntity(entity);

            headerVO.setFunctionality("SEARCHACCOUNTS");
            request.setHeader(headerVO);

            Response response = genericResponse.getResponse(url, HttpMethod.POST, request);
            ResponseVO<List<AccountData>> responseVO = response.readEntity(new GenericType<ResponseVO<List<AccountData>>>() {
            });
            responseVO.setStatus(LibraryUtil.setStatus(response));

            if (responseVO.getStatus().getCode() == 200) {
                if (!responseVO.getData().isEmpty()) {
                    List<AccountData> accountList = responseVO.getData();
                    accountData = accountList.stream()
                            .filter(account -> account.getAccountClass().equals("CREDIT"))
                            .findFirst().orElseGet(null);

                    log.info(accountData);
                    log.info("Get(0)" + accountData);
                }
            } else {
                log.info(responseVO.getStatus());
                log.info("\n" + responseVO.getErrors());
            }
        } catch (Exception e) {
            log.info("Error en conexión" + e.getMessage());
        }

        return accountData;
    }
    
    public void invokeLogin() {
        try {
            LoginService loginService = new LoginServiceImpl();
            properties();
            response = loginService.getToken(uri, user, password);
            log.info(response.getHeader().getxAuthToken());
            entity = response.getHeader().getEntity();
            rToken = response.getHeader().getxAuthToken();
        } catch (Exception e) {
            log.info(e);
        }
    }
    
	public void properties() {

		ConfigurationLoader prt = new ConfigurationLoader();
		this.user=prt.getUserws();
		this.password=prt.getPassws();
		this.uriSearchAccountWs=prt.getUriSearchAccountWs();
		this.uri=prt.getUrlws();

    }
	
	public String getrToken() {
        return rToken;
    }

    public void setrToken(String rToken) {
        this.rToken = rToken;
    }

    public ResponseVO<EntityVO> getResponse() {
        return response;
    }

    public void setResponse(ResponseVO<EntityVO> response) {
        this.response = response;
    }
	
}