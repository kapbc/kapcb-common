package com.kapcb.framework.common.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: AnalyzeUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AnalyzeUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/12 16:53
 */
@Slf4j
@UtilityClass
public class AnalyzeUtil {

    /**
     * analyze excel
     *
     * @param docPath         String
     * @param headRowNumber   Integer
     * @param modelClazz      Class<? extends M>
     * @param analyzeListener T
     * @param <M>             <M>
     * @param <T>             <T>
     * @return T
     */
    public static <M, T extends AnalysisEventListener<M>> T analyzeExcel(@NonNull String docPath, @Nullable Integer headRowNumber, @NonNull Class<? extends M> modelClazz, @NonNull T analyzeListener) {
        if (StringUtils.isBlank(docPath)) {
            throw new IllegalArgumentException("analyze excel param error, the doc path is : {}" + docPath);
        }
        String fileName = FileUtil.getPath() + docPath;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            log.error("analyze excel get io stream error, error message is : {}", e.getMessage());
        }

        ExcelReaderBuilder read = EasyExcelFactory.read(inputStream, modelClazz, analyzeListener);
        if (Objects.nonNull(headRowNumber)) {
            read.headRowNumber(headRowNumber);
        }

        ExcelReader build = read.build();
        build.readAll();
        build.finish();
        return analyzeListener;
    }

    /**
     * analyze xml
     *
     * @param xmlPath String
     * @return List<Element>
     */
    public static List<Element> analyzeXml(String xmlPath) {
        // 创建SAXReader实例
        SAXReader saxReader = new SAXReader();
        String fileName = FileUtil.getPath() + xmlPath;
        Document document = null;
        try {
            // read()读取指定的XML文档并形成DOM树
            document = saxReader.read(new File(fileName));
        } catch (DocumentException e) {
            log.error("analyze xml document error, error message is : {}", e.getMessage());
        }
        Assert.notNull(document, "document can not be null!");
        Element rootElement = document.getRootElement();
        // elements()获取根节点的子节点
        List<Element> elements = rootElement.elements();
        // 获取xml中的内容
        return elements;
    }


}
