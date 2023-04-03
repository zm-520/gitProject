package zm.project.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.project.entity.AppUser;
import zm.project.mapper.AppUserMapper;
import zm.project.service.AppUserService;
import zm.util.BeanMapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * APP用户表(AppUser)表服务实现类
 *
 * @author makejava
 * @since 2023-03-03 14:16:46
 */
@Service("appUserService")
public class AppUserServiceImpl  implements AppUserService {
    @Autowired
    AppUserMapper appUserMapper;
    @Override
    public List<Map<String,Object>> selectUserByPage(Integer pageNum, int pageSize) {
        Map<String,Object> map=new HashMap();
        pageNum=pageSize*(pageNum-1);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        List <AppUser>appUserList = appUserMapper.selectUserByPage(map);
        List<Map<String,Object>>mapList= Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(appUserList)){
            appUserList.forEach(appUser -> {
                Map<String,Object>map1= BeanMapUtils.beanToMap(appUser);
                mapList.add(map1);
            });
        }
        return mapList;
    }
}


