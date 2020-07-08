package service;

import dto.JoinAndLoginDTO;

import java.util.List;

public interface JoinAndLoginService {

  public List<JoinAndLoginDTO> selectMember();

  public List<JoinAndLoginDTO> insertMember(JoinAndLoginDTO joinAndLoginDTO);


}
