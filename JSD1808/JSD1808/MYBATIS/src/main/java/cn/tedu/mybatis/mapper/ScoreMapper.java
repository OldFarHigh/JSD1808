package cn.tedu.mybatis.mapper;

import cn.tedu.mybatis.vo.ScoreVO;

public interface ScoreMapper {

	ScoreVO findByStuId(Integer id);
}
