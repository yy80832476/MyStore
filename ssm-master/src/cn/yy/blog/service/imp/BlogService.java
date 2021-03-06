package cn.yy.blog.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yy.blog.dao.Blog;
import cn.yy.blog.dto.output.BlogDetails;
import cn.yy.blog.mapper.BlogMapper;
import cn.yy.blog.mapper.UserRoleMapper;
import cn.yy.blog.service.IBlogService;
import cn.yy.core.exception.MyException;
import cn.yy.core.mapper.IBaseMapper;
import cn.yy.core.service.BaseService;
import cn.yy.core.service.IBaseService;

/**
 *
 * @Message:  created by Liujishuai on 2015年9月24日
 * 
 * @Description:
 */
@Service
public class BlogService extends BaseService<Blog> implements IBlogService{

	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Override
	public IBaseMapper<Blog> getBaseMapper() {
		return blogMapper;
	}
   /**
    * 写博客
    */
	@Override
	public void createBlog(Blog blog, Integer userId) {
		blog.setId(null);
		blog.setUserid(userId);
		blogMapper.insertSelective(blog);
		
	}
   /**
    * 改博客
    */
	@Override
	public void updateBlog(Blog blog, Integer userId) {
		if(userId.equals(blog.getUserid())){
			blogMapper.updateByPrimaryKey(blog);
		}else {
			throw new MyException("只能修改自己的博客");
		}
		
	}
   /**
    * 删除博客
    */
	@Override
	public void deleteBlog(Integer blogId, Integer userId) {
		List<Integer> roleIdList=userRoleMapper.getRoleIdListByUserId(userId);
		if(roleIdList.contains(1)){
			//管理员爱怎么删除怎么删除
			blogMapper.deleteByPrimaryKey(blogId);
			
		}else {
			//非管理只能删自己的
			blogMapper.deleteByIdAndUserId(userId, blogId);
		}
		
		
	}
   /**
    * 获取博客列表（特定会员）
    */
	@Override
	public List<BlogDetails> getUserBlogList(Integer userId) {
		return blogMapper.getUserBlogDetails(userId);
	}

}

