package gj.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gj.entity.AdminEntity;
import gj.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, AdminEntity> {

}
