package service;

import dao.JoinAndLoginDAO;
import dto.JoinAndLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinAndLoginServiceImpl implements JoinAndLoginService{

  @Autowired
  JoinAndLoginDAO dao;

  public List<JoinAndLoginDTO> selectMember() {
    return dao.selectMember();
  }

  public List<JoinAndLoginDTO> insertMember(JoinAndLoginDTO joinAndLoginDTO) {
    return dao.insertMember(joinAndLoginDTO);
  }


}
