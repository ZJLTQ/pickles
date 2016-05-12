package org.zhangmz.pickles.modules.utils;

import org.junit.Assert;
import org.junit.Test;
import org.zhangmz.pickles.orm.model.Group;

/**
 * 测试对象拷贝工具类
 * @author dc_zjl
 *
 */
public class CopyObjectTest {
	@Test
	public void copy() throws Exception {
		Group gp = new Group();
		gp.setAdminName("testadmin");
		gp.setCode("testcode");
		gp.setGroupName("testgroup");
		gp.setPhone("testphone");
		Group gptest = (Group) CopyObject.copy(gp);
		
		Assert.assertEquals("testadmin", gptest.getAdminName());
		Assert.assertEquals("testcode", gptest.getCode());
		Assert.assertEquals("testgroup", gptest.getGroupName());
		Assert.assertEquals("testphone", gptest.getPhone());
	}
}
