package cn.yy.blog.dto.output;

import java.util.List;

import cn.yy.blog.dao.Role;
import cn.yy.blog.dao.User;

/**
 * @Description:
 */
public class UserDetails extends User{
    /**
     * 角色信息
     */
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}

