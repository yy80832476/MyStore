package cn.yy.core.service;
import cn.yy.core.mapper.IBaseMapper;

public abstract class BaseService<T> implements IBaseService<T> {
	public abstract IBaseMapper<T> getBaseMapper();

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.getBaseMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return this.getBaseMapper().insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return this.getBaseMapper().insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(Integer id) {
		return this.getBaseMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return this.getBaseMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return this.getBaseMapper().updateByPrimaryKey(record);
	}
	
}

