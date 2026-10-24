package com.sonnet.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义数据类型转换器
 */
public class DateFormatConvert implements Converter<String, Date> {

    // 进行数据类型的转换
    @Override
    public Date convert(String source) {
        if (!StringUtils.hasText(source)) {
            throw new NullPointerException("前端提交的参数不能为空");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("输入的日期格式有误", e);
        }
    }
}
