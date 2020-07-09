package dao;

import dto.JoinAndLoginDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinAndLoginDAO {

  public List<JoinAndLoginDTO> selectMember(JoinAndLoginDTO joinAndLoginDTO);

  public List<JoinAndLoginDTO> insertMember(JoinAndLoginDTO joinAndLoginDTO);
}
