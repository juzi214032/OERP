package com.juzi.oerp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setAuthor("Juzi")
                .setOpen(false)
                .setFileOverride(false)
                .setIdType(IdType.AUTO)
                .setBaseResultMap(true)
                .setEntityName("%sPO")
                .setMapperName("%sMapper")
                .setServiceName("%sService");
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3307/oerp?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dataSourceConfig);

        // 包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("com.juzi.oerp")
                .setPathInfo(getPathInfo())
                .setEntity("model.po")
                .setMapper("mapper")
                .setXml("xml");
        mpg.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setNaming(NamingStrategy.underline_to_camel)
                .setEntitySerialVersionUID(false)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                .setControllerMappingHyphenStyle(true);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig
                .setEntity("/mybatis-plus/generator/template/entity.java.vm")
                .setController("");

        mpg
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static Map<String, String> getPathInfo() {
        Map<String, String> pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.ENTITY_PATH, System.getProperty("user.dir") + "/ge/main/java/com/juzi/oerp/model/po");
        pathInfo.put(ConstVal.MAPPER_PATH, System.getProperty("user.dir") + "/ge/main/java/com/juzi/oerp/mapper");
        pathInfo.put(ConstVal.SERVICE_PATH, System.getProperty("user.dir") + "/ge/main/java/com/juzi/oerp/service");
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, System.getProperty("user.dir") + "/ge/main/java/com/juzi/oerp/service/impl");
        pathInfo.put(ConstVal.XML_PATH, System.getProperty("user.dir") + "/ge/main/resources/mybatis/xml/mapper");
        return pathInfo;
    }
}
