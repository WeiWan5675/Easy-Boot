package com.easy.admin.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.sample.dao.SampleGeneralMapper;
import com.easy.admin.sample.model.SampleGeneral;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.ImportService;
import com.easy.admin.util.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 数据导入示例
 *
 * @author TengChongChong
 * @date 2019-04-17
 */
@Service
public class SampleImportDataServiceImpl extends ServiceImpl<SampleGeneralMapper, SampleGeneral> implements ImportService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean verificationData(String templateId, String userId) {
        return true;
    }

    @Override
    public boolean beforeImport(String templateId, String userId) {
        logger.debug("templateId:{}", templateId);
        logger.debug("userId:{}", userId);
        logger.debug("beforeImport");
        return true;
    }

    @Override
    public boolean afterImport() {
        logger.debug("afterImport");
        // 导入成功后设置一些默认信息此处仅作示例
        UpdateWrapper<SampleGeneral> setDefaultValue = new UpdateWrapper<>();
        Date now = new Date();
        SysUser currentUser = ShiroUtil.getCurrentUser();
        setDefaultValue.set("create_date", now);
        setDefaultValue.set("edit_date", now);
        setDefaultValue.set("create_user", currentUser.getId());
        setDefaultValue.set("edit_user", currentUser.getId());
        update(setDefaultValue);
        return true;
    }
}
