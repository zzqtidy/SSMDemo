package com.zzq.service.impl;

import com.zzq.dao.TestDao;
import com.zzq.service.TestManager;

/**
* @ClassName: TestManagerImpl
* @Description: ���Ե�Ӧ��ʵ����
* @author tylerz
* @date 2017��4��18�� ����10:31:34
*
*/ 
public class TestManagerImpl implements TestManager {
	
	//ʹ��setterע��
	private TestDao testDao;
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	//��Ӵ�����캯��
	private TestDao testDaoConstructor;
	public TestManagerImpl(TestDao testDaoConstructor){
		this.testDaoConstructor=testDaoConstructor;
	}

	/* (�� Javadoc)
	* <p>Title: save</p>
	* <p>Description: </p>
	* @see com.zzq.service.TestManager#save()
	*/ 
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("����Service����Setter");
		testDao.save("��������ݡ���Setter");
		
		System.out.println("����Service����Constructor");
		testDaoConstructor.save("��������ݡ���Constructor");
	}

}