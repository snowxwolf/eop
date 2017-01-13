package com.xwolf.eop.util;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-12 20:38
 * @since V1.0.0
 */
public class Dom4jUtil {
    private static final String MODULE_NAME="eop";
    private static final String SRC_HOME="src";
    private static final String MAIN_HOME="main";
    private static final String TEST_HOME="test";
    private static final String RESOURCE_HOME="resources";

    private static String package2Path(String packageName){
      String[] paths=packageName.split("\\.");
      StringBuilder builder=new StringBuilder();
       for(String path:paths){
           builder.append(path).append(File.separator);
       }
       return builder.toString();
    }

    public static String getCurrentPath(){
          return System.getProperty("user.dir");
    }
    public static String getMapperPath(){
      String path=getCurrentPath()+File.separator+MODULE_NAME+File.separator+SRC_HOME+File.separator+MAIN_HOME+File.separator+RESOURCE_HOME+File.separator+package2Path("mapper.system");
      return path;
    }
    public static void main(String[] args) throws Exception {
        File mapFile = new File(getMapperPath());
        if(mapFile.isDirectory()){
                     File[] files=mapFile.listFiles();
                     for(File file:files){
                         read(file);
                     }
        }
    }

    public static void read(File file){

        try {
            System.out.println("文件名称:"+file.getName());
            String filePath=file.getAbsolutePath();
            System.out.println("文件路径:"+filePath);
            SAXReader reader=new SAXReader();
            Document document=reader.read(file);
            Element rootEle=document.getRootElement();
            List<Element> nodes=rootEle.elements();
            StringBuilder builder=new StringBuilder();
            for (Element ele:nodes){
                String name=ele.getName();

                if("select".equals(name) && "selectByPrimaryKey".equals(ele.attribute("id").getText())
                        && !"queryForList".equals(ele.attribute("id").getText())){
                    String text=ele.getText();
                    List<Element> selectLists=ele.elements();
                    String a=selectLists.get(0).getStringValue();
                    int idx=text.indexOf("where");
                    int fdx=text.indexOf("from");
                    String tableName=text.substring(fdx+4,idx);
                    builder.append("select <include refid=\"Base_Column_List\"/> from ").append(tableName);
                }
                builder.append("<where>");
                if("resultMap".equals(name)){
                          List<Element> chld=ele.elements();
                          for(Element chs:chld){
                              Attribute column=chs.attribute("column");
                              Attribute property=chs.attribute("property");
                              Attribute jdbcType=chs.attribute("jdbcType");
                              String propertyText=property.getText();
                              String columnText=column.getText();
                              String jdbcText=jdbcType.getText();

                           builder.append(" <if test= \"").append(propertyText).append(" !=null and ").
                                   append(propertyText).append(" ! ='' \" >");
                             builder.append(" and ").append(columnText).append("= #{").append(propertyText).append(",").append("jdbcType=").append(jdbcText).append("} </if>");

                          }
                          builder.append("</where>");
                          builder.append("<if test=\"order !=null and sort!=null\"> order by ${sort}  ${order} </if>");
                }

            }
            Element newElement=createEle(builder.toString());
            nodes.add(newElement);
            Writer osWrite=new OutputStreamWriter(new FileOutputStream(filePath));//创建输出流
            OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式
            format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式
            XMLWriter writer = new XMLWriter(osWrite,format);//XMLWriter 指定输出文件以及格式
            writer.write(document);//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建新的元素
     * @param text
     * @return
     */
    public static Element createEle(String text){
        Element elem = DocumentHelper.createElement("select");
        elem.addAttribute("id", "queryForList");
        elem.addAttribute("parameterType","java.util.Map");
        elem.addAttribute("resultMap","BaseResultMap");
        CDATA data=DocumentHelper.createCDATA(text);
        elem.addCDATA(text);
        return elem;
    }

    public static Element createInclude(){
        Element ele=DocumentHelper.createElement("include");
        ele.addAttribute("refid","Base_Column_List");
        return ele;
    }
}
