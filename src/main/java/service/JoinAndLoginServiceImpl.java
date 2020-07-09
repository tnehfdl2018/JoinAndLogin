package service;

import com.fasterxml.jackson.annotation.JacksonInject;
import dao.JoinAndLoginDAO;
import dao.JoinAndLoginDAOImpl;
import dto.JoinAndLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinAndLoginServiceImpl implements JoinAndLoginService{

  private JoinAndLoginDAO dao;

  @Autowired
  public void setDao (JoinAndLoginDAO dao) {
    this.dao = dao;
  }

  public List<JoinAndLoginDTO> selectMember(JoinAndLoginDTO joinAndLoginDTO) {
    return dao.selectMember(joinAndLoginDTO);
  }

  public List<JoinAndLoginDTO> insertMember(JoinAndLoginDTO joinAndLoginDTO) {
    return dao.insertMember(joinAndLoginDTO);
  }


}
