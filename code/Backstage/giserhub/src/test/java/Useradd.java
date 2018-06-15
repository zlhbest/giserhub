import com.giserhub.dao.model.UserMapper;
import com.giserhub.entity.User;
import com.giserhub.entity.UserWithBLOBs;
import com.giserhub.service.UserService;
import com.giserhub.utils.cookies.CookieUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;

public class Useradd extends SpringTestBase {
    //注入dao对象
    @Autowired//它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
    UserService userService;
    @Test
    public void insertSelective()
    {
        UserWithBLOBs userWithBLOBs = new UserWithBLOBs();
        userWithBLOBs.setsNickName("test2");
        userService.insertSelective(userWithBLOBs);
    }
    @Test
    public void updateUserinf()
    {
        UserWithBLOBs userWithBLOBs = new UserWithBLOBs();
        userWithBLOBs.setId(61);
        userWithBLOBs.setsAge(22);
        if (userService.updateUserinf(userWithBLOBs)>0)
        {
            System.out.println("成功");
        }
        else
        {
            System.out.println("失败");
        }
    }
    @Test
    public void selectuser()
    {
        UserWithBLOBs userWithBLOBs =new UserWithBLOBs();
        userWithBLOBs.setsEmail("1127913170@qq.com");
        userWithBLOBs.setsPassword("zhu123");
        UserWithBLOBs u ;
        u = userService.userLogin(userWithBLOBs);
        System.out.println(u);
    }
}
