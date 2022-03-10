package my.serviceImpl;

import my.entity.CollectRecord;
import my.mapper.CollectRecordMapper;
import my.service.CollectRecordService;
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
public class CollectRecordServiceImpl extends ServiceImpl<CollectRecordMapper, CollectRecord> implements CollectRecordService {

}
