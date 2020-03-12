package com.st.smartsecurity.pojo.vo.params;

import com.qs.common.mysql.pager.dto.PagerReqDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 公司查询VO
 * @author lhm
 */
@Data
@ApiModel(value = "公司查询VO")
public class CompanyParamsVO extends PagerReqDto {
}
