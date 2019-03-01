package co.kr.creaticoding.creaticode.mapper;

import co.kr.creaticoding.creaticode.vo.ProblemVO;

public interface ProblemMapper {
    //글작성
    public void write(ProblemVO vo)throws Exception;
}
