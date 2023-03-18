package org.oizehsgl.sub;

import org.junit.Test;

/**
 * mvcTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class MvcTest {
    private StudentModel retrieveStudentFromDatabase() {
        StudentModel studentModel = new StudentModel();
        studentModel.setName("Robert");
        studentModel.setRollNo("10");
        return studentModel;
    }

    @Test
    public void testMvc() {

        //从数据库获取学生记录
        StudentModel model = retrieveStudentFromDatabase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }
}
