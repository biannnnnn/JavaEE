package com.bdx.mybatis.test;

import com.bdx.exp02.dataSource.DataConnection;
import com.bdx.exp02.pojo.ChosenCourseDetail;
import com.bdx.exp02.pojo.ChosenCourseItem;
import com.bdx.exp02.pojo.ChosenCourseStudent;
import com.bdx.exp02.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyFirstTest {

    DataConnection dataConnection = new DataConnection();

    @Test
    // 一对一查询测试
    public void testChosenCourseStudent() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // 调用StudentMapper方法
        ChosenCourseStudent ccs = sqlSession.selectOne("findChosenCourseStudent");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        System.out.println("入学时间为：" + ccs.getSt_time() + "\n" +
                "学院是：" + ccs.getCollege() + "\n" +
                "姓名为：" + ccs.getName() + "\n" +
                "学期：" + ccs.getSemester() + "\n" +
                "选课数目：" + ccs.getCour_cout() + "\n");
    }

    @Test
    // 一对多查询测试
    public void testFindChosenCourseAndChosenCourseDetail() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // 调用StudentMapper方法
        ChosenCourseItem cci = sqlSession.selectOne("findChosenCourseAndChosenCourseDetail");
        Student student = cci.getStudent();
        List<ChosenCourseDetail> ccdList = cci.getCcd();
        System.out.println("入学时间为：" + student.getSt_time() + "\n" +
                "学院是：" + student.getCollege() + "\n" +
                "姓名为：" + student.getName());
        if (ccdList != null) {
            ChosenCourseDetail ccd = null;
            System.out.println("该名同学选的科目如下所示:");
            for (int j = 0; j < ccdList.size(); j++) {
                ccd = ccdList.get(j);
                System.out.println("课程号：" + ccd.getCour_num() +
                        " 名称为：" + ccd.getCourse());
            }
            System.out.println();
        }
    }

    @Test
    // 多对多查询测试
    public void testFindStudentAndCourse() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // 调用StudentMapper方法
        List<ChosenCourseItem> cciList = sqlSession.selectList("findStudentAndCourse");
        if (cciList != null) {
            for(int i = 0; i < cciList.size(); i ++) {
                Student student = cciList.get(i).getStudent();
                List<ChosenCourseDetail> ccdList = cciList.get(i).getCcd();
                System.out.println("入学时间为：" + student.getSt_time() + "\n" +
                        "学院是：" + student.getCollege() + "\n" +
                        "姓名为：" + student.getName());
                if (ccdList != null) {
                    ChosenCourseDetail ccd = null;
                    System.out.println("该名同学选的科目如下所示:");
                    for (int j = 0; j < ccdList.size(); j++) {
                        ccd = ccdList.get(j);
                        System.out.println("课程号：" + ccd.getCour_num() +
                                " 名称为：" + ccd.getCourse());
                    }
                    System.out.println();
                }
            }
        }
    }
}
