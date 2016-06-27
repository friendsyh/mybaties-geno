/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mybatis.generator.internal;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * @author Jeff Butler
 * 
 */
public class DefaultCommentGenerator implements CommentGenerator {

    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;

    public DefaultCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
    }

    /** 添加文件的注释 */
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    	SimpleDateFormat sdf = new SimpleDateFormat();
    	compilationUnit.addFileCommentLine("/*");
    	compilationUnit.addFileCommentLine(" * " + compilationUnit.getType().getShortName() + ".java");
    	compilationUnit.addFileCommentLine(" * Copyright(C) 2014-2016 宁波大家好科技有限公司深圳分公司");
    	compilationUnit.addFileCommentLine(" * All rights reserved.");
    	compilationUnit.addFileCommentLine(" * -------------------------------------------------------");
    	compilationUnit.addFileCommentLine(" * " + sdf.format(new Date()) + " Created.");
    	compilationUnit.addFileCommentLine(" * author:苏阳华");
    	compilationUnit.addFileCommentLine(" */");
        return;
    }

    /**
     * Adds a suitable comment to warn users that the element was generated, and
     * when it was generated.
     */
    public void addComment(XmlElement xmlElement) {
    	return ;
    }

    public void addRootComment(XmlElement rootElement) {
        // add no document level comments by default
        return;
    }

    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        
        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    /**
     * This method adds the custom javadoc tag for. You may do nothing if you do
     * not wish to include the Javadoc tag - however, if you do not include the
     * Javadoc tag then the Java merge capability of the eclipse plugin will
     * break.
     * 
     * @param javaElement
     *            the java element
     */
    protected void addJavadocTag(JavaElement javaElement,
            boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    /**
     * This method returns a formated date string to include in the Javadoc tag
     * and XML comments. You may return null if you do not want the date in
     * these documentation elements.
     * 
     * @return a string representing the current timestamp, or null
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else {
            return new Date().toString();
        }
    }

    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable) {
//    	 if (suppressAllComments) {
//             return;
//         }
         
         StringBuilder sb = new StringBuilder();

         innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
         innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator."); //$NON-NLS-1$
         sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
         sb.append(introspectedTable.getFullyQualifiedTable());
         innerClass.addJavaDocLine(sb.toString());

         addJavadocTag(innerClass, false);

         innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
//    	SimpleDateFormat sdf = new SimpleDateFormat();
//    	innerClass.addJavaDocLine("/**");
//    	innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().getRemarks());
//    	innerClass.addJavaDocLine(" * ");
//    	innerClass.addJavaDocLine(" * @author 苏阳华");
//    	innerClass.addJavaDocLine(" * @version 3.2.2");
//    	innerClass.addJavaDocLine(" * @since " + sdf.format(new Date()));
//    	innerClass.addJavaDocLine(" */");
    }

    public void addEnumComment(InnerEnum innerEnum,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
        innerEnum
                .addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addFieldComment(Field field,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        if(introspectedColumn.getRemarks() != null && !"".equals(introspectedColumn.getRemarks())){
        	field.addJavaDocLine("/** " + introspectedColumn.getRemarks() + " */");
        }
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**"); //$NON-NLS-1$
        field
                .addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addGeneralMethodComment(Method method,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$
        method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$
        sb.append(" * This method corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    public void addGetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    	return ;
    }

    public void addSetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    	return ;
    }

    public void addClassComment(InnerClass innerClass,
            IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat();
    	innerClass.addJavaDocLine("/**");
    	innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().getRemarks());
    	innerClass.addJavaDocLine(" * ");
    	innerClass.addJavaDocLine(" * @author 苏阳华");
    	innerClass.addJavaDocLine(" * @version 3.2.2");
    	innerClass.addJavaDocLine(" * @since " + sdf.format(new Date()));
    	innerClass.addJavaDocLine(" */");
    }
}
