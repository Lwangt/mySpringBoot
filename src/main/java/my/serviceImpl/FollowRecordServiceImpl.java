package my.serviceImpl;

import my.entity.FollowRecord;
import my.mapper.FollowRecordMapper;
import my.service.FollowRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@Service
public class FollowRecordServiceImpl extends ServiceImpl<FollowRecordMapper, FollowRecord> implements FollowRecordService {

}
