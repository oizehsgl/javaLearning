package org.oizehsgl.sub.controller;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * demoData
 *
 * @author oizehsgl
 * @since 3/13/23
 */
//@GroupSequence({DemoData.Insert.class, DemoData.Update.class})
@GroupSequenceProvider(CustomSequenceProvider.class)
public class DemoData {
    @NotNull(message = "integer不存在", groups = {Group.Insert.class, Group.Update.class})
    @Range(min = 1, max = 99, message = "integer范围在1~99岁")
    private Integer integer;
    @NotBlank(message = "string不存在或为空或为空白字符", groups = Group.Insert.class)
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "string格式错误")
    private String string;
    @Email(message = "邮箱格式有误")
    private String email;

    @Min(value = 2L, message = "aLong太小", groups = Group.Update.class)
    private Long aLong;

    @Valid
    @Size(min = 1, max = 10, message = "列表中的元素数量为1~10")
    private List<DemoElement> demoElementList;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public List<DemoElement> getDemoElementList() {
        return demoElementList;
    }

    public void setDemoElementList(List<DemoElement> demoElementList) {
        this.demoElementList = demoElementList;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "integer=" + integer +
                ", string='" + string + '\'' +
                ", email='" + email + '\'' +
                ", aLong=" + aLong +
                ", demoElementList=" + demoElementList +
                '}';
    }
}