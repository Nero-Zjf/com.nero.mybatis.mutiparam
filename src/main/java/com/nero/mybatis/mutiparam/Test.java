package com.nero.mybatis.mutiparam;

import com.nero.mybatis.mutiparam.po.UserPO;
import com.nero.mybatis.mutiparam.mapper.UserMapper;
import com.nero.mybatis.mutiparam.pojo.UserParam;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        try {
            //-------------------------使用 XML 构建 SqlSessionFactory-------------------------
            // 读取配置文件 mybatis-config.xml
            InputStream config = Resources
                    .getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(config);
            //--------------------------------------------------------

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();

            //获取Mapper
            UserMapper userMapper = ss.getMapper(UserMapper.class);

            // 根据用户名称或性别查询用户 （顺序传参法）
            System.out.println("--------------根据用户名称或性别查询用户 （顺序传参法）--------------------------------");
            List<UserPO> userPOList1 = userMapper.getUserByNameSex1("tom", "1");
            System.out.println(userPOList1);
            // 根据用户名称或性别查询用户 （顺序传参法）
            System.out.println("--------------根据用户名称或性别查询用户 （Map传参法）--------------------------------");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "tom");
            map.put("sex", "1");
            List<UserPO> userPOList2 = userMapper.getUserByNameSex2(map);
            System.out.println(userPOList2);

            // 根据用户名称或性别查询用户 （顺序传参法）
            System.out.println("--------------根据用户名称或性别查询用户 （POJO传参法）--------------------------------");
            UserParam param = new UserParam();
            param.setName("tom");
            param.setName("1");
            List<UserPO> userPOList3 = userMapper.getUserByNameSex3(param);
            System.out.println(userPOList3);

            // 根据用户名称或性别查询用户 （顺序传参法）
            System.out.println("--------------根据用户名称或性别查询用户 （@Param注解传参法）--------------------------------");
            List<UserPO> userPOList4 = userMapper.getUserByNameSex4("tom", "1");
            System.out.println(userPOList4);

            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
