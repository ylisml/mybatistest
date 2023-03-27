package com.imeic.test;

import com.imeic.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void findUserByIdTest(){
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try{
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e){
            e.printStackTrace();
        }
        //初始化mybatis数据库，创建sqlsessionfactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession类实例
        SqlSession session = sqlMapper.openSession();
        //传入参数查询，返回结果
        User user = session.selectOne("findById",2);
        //输出结果
        System.out.println(user.toString());
        //关闭流
        session.close();

    }

}
