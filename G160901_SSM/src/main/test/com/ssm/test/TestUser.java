package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class TestUser {

    private SqlSession sqlSession;

    @Before
    public void before(){
       /* //获取SqlSessionFactory
        try {
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }




    @Test
    public void testFind(){
      /* UserDao ud = sqlSession.getMapper(UserDao.class);
       List<User> list = ud.findAllUser();
        for (User user : list) {
            System.out.println(user);
        }*/

        //使用spring产生UserDao

        //获取spring工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) context.getBean("userDao");
        System.out.println(userDao.findAllUser().size());
    }
}
