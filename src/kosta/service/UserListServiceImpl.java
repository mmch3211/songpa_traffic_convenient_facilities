package kosta.service;

import java.sql.SQLException;

import kosta.dao.UserListDAO;
import kosta.dao.UserListDAOImpl;
import kosta.dto.UserListDTO;

public class UserListServiceImpl implements UserListService {
	UserListDAO dao = new UserListDAOImpl();

	@Override
	public boolean getCheckById(String id) throws SQLException {
		return dao.getCheckById(id);
	}

	@Override
	public int userListInsert(UserListDTO userListDTO) throws SQLException {
		int result = dao.userListInsert(userListDTO);
		if(result==0) {
			throw new SQLException("등록되지 않았습니다.");
		}
		return result;
	}

	@Override
	public UserListDTO getLogin(String id, String pw) throws SQLException {
		UserListDTO result = dao.getLogin(id, pw);
		if(result==null) {
			throw new SQLException("로그인되지 않았습니다.");
		}
		return result;
	}
	
}
