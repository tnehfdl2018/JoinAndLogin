package dao;

import dto.JoinAndLoginDTO;

import java.util.List;

public interface JoinAndLoginDAO {

  public List<JoinAndLoginDTO> selectMember();
}
