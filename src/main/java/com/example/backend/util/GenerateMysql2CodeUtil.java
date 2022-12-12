package com.example.backend.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author zhoutianlan
 * @since 2022-12-12
 **/

public class GenerateMysql2CodeUtil {
    public static void main(String[] args) {
        GenerateMysql2CodeUtilBuilder builder = new GenerateMysql2CodeUtilBuilder();
        builder.setUrl("jdbc:p6spy:mysql://124.222.178.26:3306/group10")
                .setUsername("root")
                .setPassword("12345678")
                .setClassPath("com.example.backend")
                .setEntityTemplate("/other/mybatisplus/entity.java.vm");
        GenerateMysql2CodeUtil util = builder.build();
        util.generate();
    }

    /*数据库信息配置*/
    private String url;
    private String username;
    private String password;

    /*包配置 PackageConfig*/
    private HashMap<OutputFile, String> pathInfo = new HashMap<>();
    private String classPath;

    /*模板配置 TemplateConfig*/
    // 注意：Mybatis Plus是通过类路径读取模板的，模板需要放在resources下面，然后通过例如后面的链接来获取的"/mybatisplus/template/entity.java.vm"
    private String entityTemplate;

    public void generate() {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("zhoutianlan")
                            .outputDir(Paths.get(".").toString())
                            .disableOpenDir();
                })
                .templateConfig(builder -> {
                    if (entityTemplate != null && entityTemplate.length() >= 0) {
                        builder.entity(entityTemplate);
                    }
                })
                .packageConfig(builder -> {
                    builder.parent(classPath) // 设置父包名
                            .mapper("dao")
                            .entity("pojo")
                            .service("manager")
                            .serviceImpl("manager.impl")
                            .pathInfo(pathInfo); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .enableColumnConstant()
                            .enableLombok()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .logicDeleteColumnName("is_deleted")
                            .logicDeletePropertyName("deleted")
                            .addIgnoreColumns("create_time", "update_time")
                            .idType(IdType.AUTO)
                            .formatFileName("%sDO")
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sDao")
                            .serviceBuilder()
                            .formatServiceFileName("%sManager")
                            .formatServiceImplFileName("%sManagerImp");
                })
                //.strategyConfig(builder -> builder.addInclude("airport","city","state","flight","records"))
                .execute();
    }


    public static final class GenerateMysql2CodeUtilBuilder {
        private String url;
        private String username;
        private String password;
        private String projectName;
        private String classPath;
        private String entityTemplate;

        private GenerateMysql2CodeUtilBuilder() {
        }

        public static GenerateMysql2CodeUtilBuilder aGenerateMysql2CodeUtil() {
            return new GenerateMysql2CodeUtilBuilder();
        }

        public GenerateMysql2CodeUtilBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public GenerateMysql2CodeUtilBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public GenerateMysql2CodeUtilBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public GenerateMysql2CodeUtilBuilder setProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public GenerateMysql2CodeUtilBuilder setClassPath(String classPath) {
            this.classPath = classPath;
            return this;
        }

        public GenerateMysql2CodeUtilBuilder setEntityTemplate(String entityTemplate) {
            this.entityTemplate = entityTemplate;
            return this;
        }

        private void initPathInfo(HashMap<OutputFile, String> pathInfo) {
            String classPath = this.classPath.replace('.', '/');
            String projectPath;
            if (projectName == null) {
                projectPath = "src/main";
            } else {
                projectPath = Paths.get(projectName,"src/main").toString();
            }
            String javaFileBasePath = Paths.get(projectPath, "java", classPath).toString();
            String xmlFilePath = Paths.get(projectPath, "resources").toString();
            pathInfo.put(OutputFile.controller, Paths.get(javaFileBasePath, "controller").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.mapper, Paths.get(javaFileBasePath, "dao").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.entity, Paths.get(javaFileBasePath, "pojo").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.service, Paths.get(javaFileBasePath, "manager").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.serviceImpl, Paths.get(javaFileBasePath, "manager", "impl").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.xml, Paths.get(xmlFilePath, "mapper").normalize().toAbsolutePath().toString());
            pathInfo.put(OutputFile.other, Paths.get(xmlFilePath, "other").normalize().toAbsolutePath().toString());
        }

        public GenerateMysql2CodeUtil build() {
            GenerateMysql2CodeUtil generateMysql2CodeUtil = new GenerateMysql2CodeUtil();
            generateMysql2CodeUtil.entityTemplate = this.entityTemplate;
            generateMysql2CodeUtil.password = this.password;
            generateMysql2CodeUtil.url = this.url;
            generateMysql2CodeUtil.username = this.username;
            generateMysql2CodeUtil.classPath = this.classPath;

            initPathInfo(generateMysql2CodeUtil.pathInfo);

            return generateMysql2CodeUtil;
        }
    }
}
