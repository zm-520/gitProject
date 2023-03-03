package zm.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zm.demo.entity.AppUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * APP用户表(AppUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-03 14:16:39
 */
@Mapper
@Repository
public interface AppUserMapper{
    List<AppUser> selectUserByPage(Map<String,Object> map);

}
