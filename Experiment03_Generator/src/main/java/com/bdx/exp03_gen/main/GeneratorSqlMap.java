package com.bdx.exp03_gen.main;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlMap {
    public void generator() throws Exception {
       // ���ڷ������ɹ����о�����Ϣ�ļ��϶���
        List<String> warnings = new ArrayList<>();
        // ָ���Ƿ񸲸������ļ�
        boolean overwrite = true;
        // ���������ļ�
        File configFile = new File("/Users/bian/Code/JavaEE��ҵ/Experiment03_Generator/src/main/resources/generatorConfig.xml");
        // ���ý�����
        ConfigurationParser cp = new ConfigurationParser(warnings);
        // ���ý���������ļ�������Configuration���ö���
        Configuration config = cp.parseConfiguration(configFile);
        // ������δ����ظ��ļ�
        ShellCallback callback = new DefaultShellCallback(overwrite);
        // ���򹤳̶���
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // ִ�������ļ����ɲ���
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {
        GeneratorSqlMap generatorSqlMap = new GeneratorSqlMap();
        generatorSqlMap.generator();
    }
}
