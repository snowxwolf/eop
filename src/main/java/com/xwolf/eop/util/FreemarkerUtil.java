package com.xwolf.eop.util;

import com.xwolf.eop.common.pojo.Global;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * <p>
 *     生成模板文件
 * </p>
 *
 * @author xwolf
 * @date 2017-01-05 11:42
 * @since V1.0.0
 */
public class FreemarkerUtil {

    private static String ENCODING=Global.DEFAULT_ENCODING;
    private static Configuration configuration;
    static{
        try {
            FreeMarkerConfigurationFactory freeMarkerConfigurationFactory=new FreeMarkerConfigurationFactory();
            configuration= freeMarkerConfigurationFactory.createConfiguration();
            configuration.setClassForTemplateLoading(FreemarkerUtil.class,"/template");
            configuration.setDefaultEncoding(ENCODING);
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据模板文件返回Template对象
     * @param tpl
     * @return
     */
    public static Template geneTemplate(String tpl){
        try {
            Template template= configuration.getTemplate(tpl);
            return template;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 输出到指定路径
     * @param tpl
     * @param data
     * @param targetFile
     * @throws Exception
     */
    public static void gene(String tpl, Map<String,Object> data, String targetFile) throws  Exception{
       Template template= configuration.getTemplate(tpl);
        // 生成静态页面
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile),ENCODING));
        template.process(data, out);
        out.flush();
        out.close();
    }

}
