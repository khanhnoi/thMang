package model.bo;

import java.util.ArrayList;

import model.bean.User;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {

	CheckLoginDAO checkLoginDAO=new CheckLoginDAO();
	public boolean isValidUser(String userName,String password) {
		return checkLoginDAO.isExistUser(userName, password);
	}
	public ArrayList<User>getUserList(String userName){
		return checkLoginDAO.getUserList(userName);
	}
	public User CheckLogin(String username, String password) {
		return checkLoginDAO.CheckLogin(username,password);
	}

}
