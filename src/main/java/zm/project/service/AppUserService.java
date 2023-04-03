package zm.project.service;


import java.util.List;
import java.util.Map;

/**
 * APP用户表(AppUser)表服务接口
 *
 * @author makejava
 * @since 2023-03-03 14:16:44
 */
public interface AppUserService{
    List<Map<String,Object>> selectUserByPage(Integer pageNum, int pageSize);
}
