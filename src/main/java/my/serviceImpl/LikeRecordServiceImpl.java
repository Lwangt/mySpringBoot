package my.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.entity.LikeRecord;
import my.mapper.LikeRecordMapper;
import my.service.LikeRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwangt
 * @since 2022-04-30
 */
@Service
public class LikeRecordServiceImpl extends ServiceImpl<LikeRecordMapper, LikeRecord> implements LikeRecordService {

}
