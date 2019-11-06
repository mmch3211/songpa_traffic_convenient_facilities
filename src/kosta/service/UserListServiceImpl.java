package kosta.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

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
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public UserListDTO getLogin(String id, String pw) throws SQLException {
		UserListDTO result = dao.getLogin(id, pw);
		if(result==null) {
			throw new SQLException("�α��ε��� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public int favoriteUpdate(String id, String ComName, String ComAddr) throws SQLException {
		int result = dao.favoriteUpdate(id, ComName, ComAddr);
		if(result==0) {
			throw new SQLException("���ã�⿡ �߰����� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public int favoriteDelete(String id, String ComName, String ComAddr) throws SQLException {
		int result = dao.favoriteDelete(id, ComName, ComAddr);
		if(result==0) {
			throw new SQLException("���ã�⿡ �������� �ʾҽ��ϴ�.");
		}
		return result;
	}

	@Override
	public List<Vector<Object>> getFavoriteList(String id) throws SQLException {
		List<Vector<Object>> list = dao.getFavoriteList(id);
		if(list.isEmpty() || list==null) {
			throw new SQLException("���ã�⸦ �ҷ��� �� �����ϴ�.");
		}
		return list;
	}
	
}
