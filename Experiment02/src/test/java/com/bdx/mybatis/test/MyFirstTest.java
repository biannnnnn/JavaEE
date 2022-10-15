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
    // һ��һ��ѯ����
    public void testChosenCourseStudent() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // ����StudentMapper����
        ChosenCourseStudent ccs = sqlSession.selectOne("findChosenCourseStudent");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        System.out.println("��ѧʱ��Ϊ��" + ccs.getSt_time() + "\n" +
                "ѧԺ�ǣ�" + ccs.getCollege() + "\n" +
                "����Ϊ��" + ccs.getName() + "\n" +
                "ѧ�ڣ�" + ccs.getSemester() + "\n" +
                "ѡ����Ŀ��" + ccs.getCour_cout() + "\n");
    }

    @Test
    // һ�Զ��ѯ����
    public void testFindChosenCourseAndChosenCourseDetail() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // ����StudentMapper����
        ChosenCourseItem cci = sqlSession.selectOne("findChosenCourseAndChosenCourseDetail");
        Student student = cci.getStudent();
        List<ChosenCourseDetail> ccdList = cci.getCcd();
        System.out.println("��ѧʱ��Ϊ��" + student.getSt_time() + "\n" +
                "ѧԺ�ǣ�" + student.getCollege() + "\n" +
                "����Ϊ��" + student.getName());
        if (ccdList != null) {
            ChosenCourseDetail ccd = null;
            System.out.println("����ͬѧѡ�Ŀ�Ŀ������ʾ:");
            for (int j = 0; j < ccdList.size(); j++) {
                ccd = ccdList.get(j);
                System.out.println("�γ̺ţ�" + ccd.getCour_num() +
                        " ����Ϊ��" + ccd.getCourse());
            }
            System.out.println();
        }
    }

    @Test
    // ��Զ��ѯ����
    public void testFindStudentAndCourse() throws IOException {
        SqlSession sqlSession = dataConnection.getSqlSession();

        // ����StudentMapper����
        List<ChosenCourseItem> cciList = sqlSession.selectList("findStudentAndCourse");
        if (cciList != null) {
            for(int i = 0; i < cciList.size(); i ++) {
                Student student = cciList.get(i).getStudent();
                List<ChosenCourseDetail> ccdList = cciList.get(i).getCcd();
                System.out.println("��ѧʱ��Ϊ��" + student.getSt_time() + "\n" +
                        "ѧԺ�ǣ�" + student.getCollege() + "\n" +
                        "����Ϊ��" + student.getName());
                if (ccdList != null) {
                    ChosenCourseDetail ccd = null;
                    System.out.println("����ͬѧѡ�Ŀ�Ŀ������ʾ:");
                    for (int j = 0; j < ccdList.size(); j++) {
                        ccd = ccdList.get(j);
                        System.out.println("�γ̺ţ�" + ccd.getCour_num() +
                                " ����Ϊ��" + ccd.getCourse());
                    }
                    System.out.println();
                }
            }
        }
    }
}
